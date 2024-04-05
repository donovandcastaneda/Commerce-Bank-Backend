package net.commercebank.cb.service;

import java.util.List;

import net.commercebank.cb.dto.*;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long id);

    UserDto deposit(Long id, double amount);

    UserDto withdraw(Long id, double amount);

    List<UserDto> getAllUsers();

    void deleteUser(Long id);
}
