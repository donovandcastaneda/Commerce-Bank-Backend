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
                userDto.getTotalDeposited(),
                userDto.getTotalWithdrawn(),
                userDto.getAccounts()



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
                user.getTotalDeposited(),
                user.getTotalWithdrawn(),
                user.getAccounts()

        );

        return userDto;
    }
}
