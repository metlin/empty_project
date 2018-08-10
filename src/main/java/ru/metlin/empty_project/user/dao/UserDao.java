package ru.metlin.empty_project.user.dao;

import ru.metlin.empty_project.SuccessView;
import ru.metlin.empty_project.user.model.User;

public interface UserDao {

    void add(User user);

    void update(User user);

    Iterable<User> all();

    User getById(Long id);
}
