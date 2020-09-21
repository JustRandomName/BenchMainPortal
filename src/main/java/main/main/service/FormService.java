package main.main.service;

import static main.main.util.FormUtil.fromDtoToModel;
import static main.main.util.FormUtil.fromModelToDto;

import main.main.repository.FormRepository;
import model.dto.FormDto;
import model.entity.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormService {
    private FormRepository formRepository;

    @Autowired
    public FormService(final FormRepository formRepository) {
        this.formRepository = formRepository;
    }

    public FormDto save(final FormDto formDto) {
        final Form form = fromDtoToModel(formDto);
        return fromModelToDto(formRepository.save(form));
    }
}
