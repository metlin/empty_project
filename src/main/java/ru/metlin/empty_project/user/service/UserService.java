package ru.metlin.empty_project.user.service;

import ru.metlin.empty_project.SuccessView;
import ru.metlin.empty_project.user.model.User;
import ru.metlin.empty_project.user.request.SaveUserRequest;
import ru.metlin.empty_project.user.request.UpdateUserRequest;
import ru.metlin.empty_project.user.response.GetUser;
import ru.metlin.empty_project.user.response.UserList;

import java.util.List;

public interface UserService {

    SuccessView save(SaveUserRequest request) throws Exception;

    SuccessView update(UpdateUserRequest request) throws Exception;

    List<UserList> findAll() throws Exception;

    GetUser findById(Long id) throws Exception;
}