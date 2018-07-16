package ru.metlin.empty_project.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api/user/")
public class UserController {

    @PostMapping(value = "/list")
    private List<User> getUserList(@RequestBody UserListRequest request) {
        User user = new User();
        user.setId(15L);
        user.setFirstName("Ivan");
        user.setSecondName("Petrov");
        user.setMiddleName("Andry");
        user.setPosition("Manager");
        user.setSitizenshipCode(12345L);
        user.setDocCode(432432L);

        return Arrays.asList(user, user, user);
    }

    @GetMapping(value = "/{id}")
    private User getUser(@PathVariable Long id) {
        User user = new User();
        user.setId(id);
        user.setFirstName("Artur");
        user.setSecondName("Ivanov");
        user.setMiddleName("Petr");
        user.setPosition("Manager");
        user.setPhone("8(495)123-34-45");
        user.setDocName("Xz");

        return user;
    }

    @PostMapping(value = "/update")
    private String updateUser(@RequestBody UpdateUserRequest request) {
        return "success";
    }

    @PostMapping(value = "/save")
    private String createUser(@RequestBody SaveUserRequest request) {
        return "success";
    }

}
