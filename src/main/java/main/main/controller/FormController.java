package main.main.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import main.main.service.FormService;
import model.dto.FormDto;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/form/create", method = POST)
    public FormDto create(@RequestBody FormDto formDto) {
        System.out.println(123);
        return formService.save(formDto);
    }
}
