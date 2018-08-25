package ru.metlin.empty_project.user.dao;

import ru.metlin.empty_project.user.model.User;
import ru.metlin.empty_project.user.request.UserListRequest;

import java.util.List;

public interface UserDao {

    void add(User user);

    void update(User user);

    List<User> all(UserListRequest user);

    User getById(Long id);
}
