package main.main.util;

import static java.time.LocalDate.now;

import model.dto.FormDto;
import model.entity.Form;

public final class FormUtil {
    protected FormUtil() {
    }

    public static Form fromDtoToModel(final FormDto dto) {
        return new Form(dto.getId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getMiddleName(),
                now(),
                dto.getRequest(),
                dto.getPhone());
    }

    public static FormDto fromModelToDto(final Form form) {
        return new FormDto(form.getId(),
                form.getFirstName(),
                form.getLastName(),
                form.getMiddleName(),
                now(),
                form.getRequest(),
                form.getPhone());
    }
}
