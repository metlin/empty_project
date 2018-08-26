package ru.metlin.empty_project.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.metlin.empty_project.response.SuccessView;
import ru.metlin.empty_project.user.request.SaveUserRequest;
import ru.metlin.empty_project.user.request.UpdateUserRequest;
import ru.metlin.empty_project.user.request.UserListRequest;
import ru.metlin.empty_project.user.service.UserService;
import ru.metlin.empty_project.user.view.GetUser;
import ru.metlin.empty_project.user.view.UserList;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user/")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/list")
    private List<UserList> getOfficeList(@RequestBody UserListRequest request) {

        return userService.findAll(request);
    }

    @GetMapping(value = "/{id}")
    private GetUser getOffice(@PathVariable Long id) {

            return userService.findById(id);
    }

    @PostMapping(value = "/save")
    private SuccessView createOffice(@RequestBody SaveUserRequest request)  {

        return userService.save(request);
    }

    @PostMapping(value = "/update")
    private SuccessView updateOffice(@RequestBody UpdateUserRequest request)  {

        return userService.update(request);
    }
}

