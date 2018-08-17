package ru.metlin.empty_project.user.dao;

import ru.metlin.empty_project.SuccessView;
import ru.metlin.empty_project.user.model.User;

import java.util.List;

public interface UserDao {

    void add(User user);

    void update(User user);

    List<User> all();

    User getById(Long id);
}