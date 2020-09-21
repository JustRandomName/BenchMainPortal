package main.main.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import main.main.service.UserDetailsServiceImpl;
import model.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserDetailsServiceImpl detailsService;

    @Autowired
    public UserController(final UserDetailsServiceImpl detailsService) {
        this.detailsService = detailsService;
    }

    @RequestMapping(value = "/getUserInfo", method = POST)
    public UserDto get(@RequestBody final UserDto dto) {
        return detailsService.getUserByUsername(dto);
    }
}
