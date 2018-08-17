package ru.metlin.empty_project.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.metlin.empty_project.SuccessView;
import ru.metlin.empty_project.country.dao.CountryDao;
import ru.metlin.empty_project.country.model.Country;
import ru.metlin.empty_project.document.dao.DocumentDao;
import ru.metlin.empty_project.document.model.Document;
import ru.metlin.empty_project.office.dao.OfficeDao;
import ru.metlin.empty_project.office.model.Office;
import ru.metlin.empty_project.user.dao.UserDao;
import ru.metlin.empty_project.user.model.User;
import ru.metlin.empty_project.user.request.SaveUserRequest;
import ru.metlin.empty_project.user.request.UpdateUserRequest;
import ru.metlin.empty_project.user.response.GetUser;
import ru.metlin.empty_project.user.response.UserList;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final OfficeDao officeDao;
    private final DocumentDao documentDao;
    private final CountryDao countryDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, OfficeDao officeDao, DocumentDao documentDao, CountryDao countryDao) {
        this.userDao = userDao;
        this.officeDao = officeDao;
        this.documentDao = documentDao;
        this.countryDao = countryDao;
    }

    @Override
    @Transactional
    public SuccessView save(SaveUserRequest request) throws Exception {

        String firstName = request.getFirstName();

        if (firstName == null) {
            throw new Exception("User should have a name");
        }

        for (int i = 0; i < firstName.length(); i++) {
            if (firstName.charAt(i) == ' ') {
                throw new Exception("the name must not contain spaces");
            }
        }

        for (int i = 0; i < firstName.length(); i++) {
            if (firstName.charAt(i) < 'A' || firstName.charAt(i) > 'z' ) {
                throw new Exception("the name cannot contain symbols");
            }
        }

        if (request.getPosition() == null) {
            throw new Exception("user should have a position");
        }

        if (request.getOfficeId() == 0) {
            throw new Exception("this user does not exist");
        }

        Office office = officeDao.getById(request.getOfficeId());

        if (office == null) {
            throw new Exception("User should have an office");
        }

        if (request.getDocId() == 0) {
            throw new Exception("the user must have a document");
        }

        Document document = documentDao.getById(request.getDocId());

        if (document == null) {
            throw new Exception("User should have a document");
        }

        if (request.getCountryId() == 0) {
            throw new Exception("the user must belong to the country");
        }

        Country country = countryDao.getById(request.getCountryId());

        if (country == null) {
            throw new Exception("User should have a country");
        }

        User user = new User(request);
        user.setOffice(office);
        office.addUser(user);
        user.setDocument(document);
        user.setCountry(country);

        userDao.add(user);

        return new SuccessView();
    }

    @Override
    @Transactional
    public SuccessView update(UpdateUserRequest request) throws Exception {

        if (request.getId() == 0) {
            throw new Exception("the user must have an ID");
        }

        String firstName = request.getFirstName();

        if (firstName == null) {
            throw new Exception("User should have a name");
        }

        for (int i = 0; i < firstName.length(); i++) {
            if (firstName.charAt(i) == ' ') {
                throw new Exception("the name must not contain spaces");
            }
        }

        for (int i = 0; i < firstName.length(); i++) {
            if (firstName.charAt(i) < 'A' || firstName.charAt(i) > 'z' ) {
                throw new Exception("the name cannot contain symbols");
            }
        }

        if (request.getPosition() == null) {
            throw new Exception("user should have a position");
        }

        if (request.getOfficeId() == 0) {
            throw new Exception("this user does not exist");
        }

        Office office = officeDao.getById(request.getOfficeId());

        if (request.getDocId() == 0) {
            throw new Exception("the user must have a document");
        }

        Document document = documentDao.getById(request.getDocId());

        if (document == null) {
            throw new Exception("User should have a document");
        }

        if (request.getCountryId() == 0) {
            throw new Exception("the user must belong to the country");
        }

        Country country = countryDao.getById(request.getCountryId());

        if (country == null) {
            throw new Exception("User should have a country");
        }

        User user = new User(request);
        user.setOffice(office);
        user.setDocument(document);
        user.setCountry(country);

        userDao.update(user);

        return new SuccessView();
    }

    @Override
    @Transactional
    public List<UserList> findAll() throws Exception {

        List<User> userList = userDao.all();

        if (userList == null) {
            throw new Exception("userList does not exist");
        }

        List<UserList> userListResponse = new ArrayList<>();

        for (int i = 0; i < userList.size(); i++) {
            userListResponse.add(new UserList(userList.get(i)));
        }

        return userListResponse;
    }

    @Override
    @Transactional
    public GetUser findById(Long id) throws Exception {

        if (id < 1) {
            throw new Exception("id greater than 0");
        }

        User user = userDao.getById(id);

        if (user == null) {
            throw new Exception("this user does not exist");
        }

        return new GetUser(user);
    }
}