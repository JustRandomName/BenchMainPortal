package main.main.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import main.main.service.FormService;
import model.dto.FormDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author n.zhuchkevich
 * @since 09/22/2020
 * */
@RestController(value = "/form")
public class FormController {

    private final FormService formService;

    @Autowired
    public FormController(final FormService formService) {
        this.formService = formService;
    }

    @RequestMapping(value = "/create", method = POST)
    public FormDto create(@RequestBody final FormDto formDto) {
        return formService.create(formDto);
    }

    @RequestMapping(value = "/getForm", method = POST)
    public FormDto create(@RequestBody final String id) {
        return formService.retrieveById(id);
    }
//
//    @RequestMapping(value = "/getUserForms", method = POST)
//    public List<FormDto> getUserForms(@RequestBody final String userId) {
//        return formService.retrieveUserFormsByUserId(userId);
//    }

}
