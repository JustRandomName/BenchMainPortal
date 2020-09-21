package main.main.util;

import static java.lang.String.valueOf;

import model.dto.UserDto;
import model.entity.User;

/**
 * @author n.zhuchkevich
 * @since 09/21/2020
 */
public final class UserUtil {

    public static UserDto fromEntityToDto(final User user) {
        return new UserDto(valueOf(user.getId()),
                user.getFirstName(),
                user.getLastName(),
                user.getMiddleName(),
                user.getDOB(),
                user.getPassword(),
                user.getUsername(),
                user.isEnabled());
    }

    protected UserUtil() {
    }
}
