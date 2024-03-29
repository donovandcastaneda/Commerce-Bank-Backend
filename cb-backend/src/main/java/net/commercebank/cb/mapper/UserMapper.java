package net.commercebank.cb.mapper;

import net.commercebank.cb.dto.*;
import net.commercebank.cb.entity.*;

public class UserMapper {

    public static User mapToUser(UserDto userDto) {
        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getBalance(),
                userDto.getRole()
        );

        return user;
    }

    public static UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getUsername(),
                user.getPassword(),
                user.getBalance(),
                user.getRole()
        );

        return userDto;
    }
}
