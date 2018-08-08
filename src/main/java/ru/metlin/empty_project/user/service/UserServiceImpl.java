package ru.metlin.empty_project.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.metlin.empty_project.SuccessView;
import ru.metlin.empty_project.office.dao.OfficeDao;
import ru.metlin.empty_project.office.model.Office;
import ru.metlin.empty_project.user.dao.UserDao;
import ru.metlin.empty_project.user.model.User;
import ru.metlin.empty_project.user.request.SaveUserRequest;
import ru.metlin.empty_project.user.request.UpdateUserRequest;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final OfficeDao officeDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, OfficeDao officeDao) {
        this.userDao = userDao;
        this.officeDao = officeDao;
    }

    @Override
    @Transactional
    public SuccessView save(SaveUserRequest request) throws Exception {

        if (request.getPhone() == null) {
            throw new Exception("this user does not exist");
        }

        Office office = officeDao.getById(request.getOfficeId());

        if (office == null) {
            throw new Exception("User should have an office");
        }

        User user = new User(request);

        user.setOffice(office);

        office.addUser(user);

        System.out.println(office.getUserList());

        return userDao.add(user);
    }

    @Override
    @Transactional
    public SuccessView update(UpdateUserRequest request) throws Exception {

        if (request.getId() == 0) {
            throw new Exception("this user does not exist");
        }

        User user = new User(request);

        return userDao.add(user);
    }

    @Override
    @Transactional
    public Iterable<User> findAll() {
        return userDao.all();
    }

    @Override
    @Transactional
    public User findById(Long id) throws Exception {

        if (id == 0) {
            throw new Exception("this user does not exist");
        }

        return userDao.getById(id);
    }
}
