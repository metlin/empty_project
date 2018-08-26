package ru.metlin.empty_project.user.service;

import ru.metlin.empty_project.response.SuccessView;
import ru.metlin.empty_project.user.request.SaveUserRequest;
import ru.metlin.empty_project.user.request.UpdateUserRequest;
import ru.metlin.empty_project.user.request.UserListRequest;
import ru.metlin.empty_project.user.view.GetUser;
import ru.metlin.empty_project.user.view.UserList;

import java.util.List;

public interface UserService {

    SuccessView save(SaveUserRequest request);

    SuccessView update(UpdateUserRequest request);

    List<UserList> findAll(UserListRequest request);

    GetUser findById(Long id);
}
