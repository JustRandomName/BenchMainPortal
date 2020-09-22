package main.main.service;

import static java.util.UUID.fromString;
import static model.utils.FormUtil.fromDtoToModel;
import static model.utils.FormUtil.fromModelToDto;

import main.main.repository.FormRepository;
import model.dto.FormDto;
import model.entity.Form;
import model.utils.FormUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author n.zhuchkevich
 * @since 09/21/2020
 */
@Service
public class FormService {
    private final FormRepository formRepository;

    @Autowired
    public FormService(final FormRepository formRepository) {
        this.formRepository = formRepository;
    }

    public FormDto create(final FormDto formDto) {
        final Form form = fromDtoToModel(formDto);
        return fromModelToDto(formRepository.save(form));
    }

    public FormDto retrieveById(final String id) {
        final Optional<Form> form = formRepository.findById(fromString(id));
        return form.map(FormUtil::fromModelToDto).orElseGet(FormDto::new);
    }
}
