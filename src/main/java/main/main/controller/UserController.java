package main.main.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import main.main.service.UserDetailsServiceImpl;
import models.models.dto.UserDto;
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

    @RequestMapping(value = "/registration", method = POST)
    public void register(@RequestBody final UserDto dto) {
        detailsService.saveUser(dto);
    }

    @RequestMapping(value = "/auth", method = POST)
    public UserDto auth(@RequestBody final UserDto dto) throws Exception {
        return detailsService.authenticate(dto);
    }
}
