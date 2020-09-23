package main.main.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import main.main.service.UserService;
import model.dto.FormDto;
import model.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author n.zhuchkevich
 * @since 09/21/2020
 * */
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(final UserService detailsService) {
        this.userService = detailsService;
    }

    @RequestMapping(value = "/getUserInfo", method = POST)
    public UserDto get(@RequestBody final String username) {
        return userService.getUserByUsername(username);
    }

    @RequestMapping(value = "/getUserForms", method = POST)
    public List<FormDto> create(@RequestBody final String userId) {
        return userService.retrieveUserForms(userId);
    }
}
