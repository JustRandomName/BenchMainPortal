package main.main.service;

import static java.util.UUID.fromString;
import static java.util.stream.Collectors.toList;
import static model.utils.FormUtil.fromDtoToModel;
import static model.utils.FormUtil.fromModelToDto;

import main.main.repository.FormRepository;
import main.main.repository.UserRepository;
import model.dto.FormDto;
import model.entity.Form;
import model.entity.User;
import model.utils.FormUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author n.zhuchkevich
 * @since 09/21/2020
 */
@Service
public class FormService {
    private final FormRepository formRepository;
    private final UserRepository userRepository;

    @Autowired
    public FormService(final FormRepository formRepository,
                       final UserRepository userRepository) {
        this.formRepository = formRepository;
        this.userRepository = userRepository;
    }

    public FormDto create(final FormDto formDto) {
        final Form form = fromDtoToModel(formDto, userRepository.findById(fromString(formDto.getUserId())).get());
        return fromModelToDto(formRepository.save(form));
    }

    public FormDto retrieveById(final String id) {
        final Optional<Form> form = formRepository.findById(fromString(id));
        return form.map(FormUtil::fromModelToDto).orElseGet(FormDto::new);
    }

    public List<FormDto> retrieveUserFormsByUserId(final String id) {
        final Optional<User> user = userRepository.findById(fromString(id));
        return user.map(
                value -> formRepository.findAllByUser(value).stream().
                        map(FormUtil::fromModelToDto).
                        collect(toList()))
                .orElseGet(ArrayList::new);
    }
}
