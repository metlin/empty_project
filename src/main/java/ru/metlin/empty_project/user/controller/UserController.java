package ru.metlin.empty_project.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.metlin.empty_project.user.model.User;
import ru.metlin.empty_project.user.model.UserRepository;
import ru.metlin.empty_project.user.request.SaveUserRequest;
import ru.metlin.empty_project.user.request.UpdateUserRequest;
import ru.metlin.empty_project.user.request.UserListRequest;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/user/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/list")
    private Iterable<User> getUserList(@RequestBody UserListRequest request) {
        return userRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    private Optional<User> getUser(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @PostMapping(value = "/update")
    private User updateUser(@RequestBody UpdateUserRequest request) {
        User user = new User(request);
        return userRepository.save(user);
    }

    @PostMapping(value = "/save")
    private User createUser(@RequestBody SaveUserRequest request) {
        User user = new User(request);
        return userRepository.save(user);
    }
}
