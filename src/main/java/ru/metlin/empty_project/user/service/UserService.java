package ru.metlin.empty_project.user.service;

import ru.metlin.empty_project.general_response.SuccessView;
import ru.metlin.empty_project.user.request.SaveUserRequest;
import ru.metlin.empty_project.user.request.UpdateUserRequest;
import ru.metlin.empty_project.user.request.UserListRequest;
import ru.metlin.empty_project.user.response.GetUser;
import ru.metlin.empty_project.user.response.UserList;

import java.util.List;

public interface UserService {

    SuccessView save(SaveUserRequest request);

    SuccessView update(UpdateUserRequest request);

    List<UserList> findAll(UserListRequest request);

    GetUser findById(Long id);
}
