package ru.metlin.empty_project.user.service;

import ru.metlin.empty_project.SuccessView;
import ru.metlin.empty_project.user.model.User;
import ru.metlin.empty_project.user.request.SaveUserRequest;
import ru.metlin.empty_project.user.request.UpdateUserRequest;

public interface UserService {

    SuccessView save(SaveUserRequest request) throws Exception;

    SuccessView update(UpdateUserRequest request) throws Exception;

    Iterable<User> findAll();

    User findById(Long id) throws Exception;
}
