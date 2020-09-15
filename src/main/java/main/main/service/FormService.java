package main.main.service;

import static main.main.util.FormUtil.fromDtoToModel;
import static main.main.util.FormUtil.fromModelToDto;

import main.main.repository.FormRepository;
import main.main.util.AuthService;
import models.models.dto.FormDto;
import models.models.entity.Form;
import models.models.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormService {
    private FormRepository formRepository;
    private AuthService authService;

    @Autowired
    public FormService(final FormRepository formRepository,
                       final AuthService authService) {
        this.formRepository = formRepository;
        this.authService = authService;
    }

    public FormDto save(final FormDto formDto) {
        final User user = authService.getCurrentUser();
        final Form form = fromDtoToModel(formDto);
        form.setUser(user);
        return fromModelToDto(formRepository.save(form));
    }
}
