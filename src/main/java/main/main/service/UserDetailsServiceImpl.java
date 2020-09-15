package main.main.service;

import static java.util.Collections.singleton;
import static main.main.util.UserUtil.fromDtoToEntity;
import static main.main.util.UserUtil.fromEntityToDto;

import main.main.config.DefaultAuthenticationEntryPoint;
import main.main.repository.UserRepository;
import main.main.util.JwtTokenUtil;
import models.models.dto.UserDto;
import models.models.entity.Role;
import models.models.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final String USER_DISABLED = "USER_DISABLED";
    private static final String INVALID_CREDENTIALS = "INVALID_CREDENTIALS";

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public User loadUserByUsername(final String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public User saveUser(final UserDto dto) {
        dto.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        final User user = fromDtoToEntity(dto);
        user.setRoles(singleton(new Role("ROLE_USER")));
        return userRepository.save(user);
    }

    public UserDto authenticate(final UserDto dto) throws Exception {
        User user = loadUserByUsername(dto.getUsername());
        authenticate(dto.getUsername(), dto.getPassword(), user);
        final String token = jwtTokenUtil.generateToken(user);
        return fromEntityToDto(user, token);
    }

    private void authenticate(final String username, final String password, User user) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities()));
        } catch (DisabledException e) {
            throw new Exception(USER_DISABLED, e);
        } catch (BadCredentialsException e) {
            throw new Exception(INVALID_CREDENTIALS, e);
        }
    }

}
