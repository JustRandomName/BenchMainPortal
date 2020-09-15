package main.main.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import main.main.service.FormService;
import models.models.dto.FormDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormController {

    private FormService formService;

    @Autowired
    public FormController(final FormService formService) {
        this.formService = formService;
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/form/create", method = POST)
    public FormDto create(@RequestBody FormDto formDto) {
        return formService.save(formDto);
    }
}
