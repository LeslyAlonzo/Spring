package org.adaschool.datapostgres.controller;

import org.adaschool.datapostgres.dto.UserDto;
import org.adaschool.datapostgres.entity.User;
import org.adaschool.datapostgres.exception.UserNotFoundException;
import org.adaschool.datapostgres.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @PostMapping("/{id}")
    public User createUser(@RequestBody UserDto userDto){
        User user = new User(userDto.getName(), userDto.getEmail());
        return userRepository.save(user);
    }
    public User findById(@PathVariable Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
            return optionalUser.get();
        } else {
            throw new UserNotFoundException();
        }
    }
}
