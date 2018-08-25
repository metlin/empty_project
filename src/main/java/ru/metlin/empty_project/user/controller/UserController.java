package ru.metlin.empty_project.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.metlin.empty_project.user.service.UserService;

@RestController
@RequestMapping(value = "/api/user/")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

  /*  @PostMapping(value = "/list")
    private Response<List<UserList>> getOfficeList(@RequestBody UserListRequest request) {
        try {
            return new Response<List<UserList>>(userService.findAll(request));
        } catch (Exception e) {
            return new Response<List<UserList>>(e.getMessage());
        }
    }

    @GetMapping(value = "/{id}")
    private Response<GetUser> getOffice(@PathVariable Long id) {
        try {
            return new Response<GetUser>(userService.findById(id));
        } catch (Exception e) {
            return new Response<GetUser>(e.getMessage());
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
    } */
}

