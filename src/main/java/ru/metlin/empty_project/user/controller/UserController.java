package ru.metlin.empty_project.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.metlin.empty_project.Response;
import ru.metlin.empty_project.SuccessView;
import ru.metlin.empty_project.user.model.User;
import ru.metlin.empty_project.user.request.SaveUserRequest;
import ru.metlin.empty_project.user.request.UpdateUserRequest;
import ru.metlin.empty_project.user.request.UserListRequest;
import ru.metlin.empty_project.user.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/user/")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/list")
    private Iterable<User> getOfficeList(@RequestBody UserListRequest request) {
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    private Response<User> getOffice(@PathVariable Long id) {
        try {
            return new Response<User>(userService.findById(id));
        } catch (Exception e) {
            return new Response<User>(e.getMessage());
        }
    }

    @PostMapping(value = "/save")
    private Response<SuccessView> createOffice(@RequestBody SaveUserRequest request)  {
        try {
            return new Response<SuccessView>(userService.save(request));
        } catch (Exception e) {
            return new Response<SuccessView>(e.getMessage());
        }
    }

    @PostMapping(value = "/update")
    private Response<SuccessView> updateOffice(@RequestBody UpdateUserRequest request)  {
        try {
            return new Response<SuccessView>(userService.update(request));
        } catch (Exception e) {
            return new Response<SuccessView>(e.getMessage());
        }
    }
}

