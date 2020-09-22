package main.main.service;

import static model.utils.UserUtil.fromEntityToDto;

import main.main.repository.UserRepository;
import model.dto.FormDto;
import model.dto.UserDto;
import model.entity.User;
import model.utils.FormUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author n.zhuchkevich
 * @since 09/21/2020
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto getUserByUsername(final UserDto dto) {
        return fromEntityToDto(userRepository.findByUsername(dto.getUsername()));
    }

    public List<FormDto> retrieveUserForms(final String userId) {
        final Optional<User> user = userRepository.findById(userId);
        return user.map(el -> el.getForms().stream()
                .map(FormUtil::fromModelToDto)
                .collect(Collectors.toList()))
                .orElseGet(ArrayList::new);
    }

}