package net.commercebank.cb.service.impl;

import net.commercebank.cb.entity.*;
import net.commercebank.cb.dto.UserDto;
import net.commercebank.cb.mapper.UserMapper;
import net.commercebank.cb.service.*;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.*;


@Service
public class UserServiceImpl implements UserService {

    private net.commercebank.cb.repository.UserRepository userRepository;

    public UserServiceImpl(net.commercebank.cb.repository.UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long id) {

        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("User does not exist."));
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public UserDto deposit(Long id, double amount) {

        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("User account does not exist."));

        double total = user.getBalance() + amount;
        user.setBalance(total);

        double totalDeposited = user.getTotalDeposited() + amount;
        user.setTotalDeposited(totalDeposited);

        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto withdraw(Long id, double amount) {

        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("User account does not exist."));

        if(user.getBalance() < amount) {
            throw new RuntimeException("Insufficent amound");
        }

        double total = user.getBalance() - amount;
        user.setBalance(total);

        double totalWithdrawn = user.getTotalWithdrawn() + amount;
        user.setTotalWithdrawn(totalWithdrawn);

        User savedUser = userRepository.save(user);

        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> UserMapper.mapToUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Long id) {

        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("User account does not exist."));

        userRepository.deleteById(id);

    }


}
