package main.main.service;

import static main.main.util.UserUtil.fromEntityToDto;

import main.main.repository.UserRepository;
import model.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto getUserByUsername(final UserDto dto) {
        return fromEntityToDto(userRepository.findByUsername(dto.getUsername()));
    }

}
