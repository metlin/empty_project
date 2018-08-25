package ru.metlin.empty_project.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.metlin.empty_project.general_response.SuccessView;
import ru.metlin.empty_project.country.dao.CountryDao;
import ru.metlin.empty_project.country.model.Country;
import ru.metlin.empty_project.document.dao.DocumentDao;
import ru.metlin.empty_project.document.model.Document;
import ru.metlin.empty_project.exception.EmptyListException;
import ru.metlin.empty_project.exception.InvalidNameException;
import ru.metlin.empty_project.exception.InvalidValueException;
import ru.metlin.empty_project.office.dao.OfficeDao;
import ru.metlin.empty_project.office.model.Office;
import ru.metlin.empty_project.user.dao.UserDao;
import ru.metlin.empty_project.user.model.User;
import ru.metlin.empty_project.user.request.SaveUserRequest;
import ru.metlin.empty_project.user.request.UpdateUserRequest;
import ru.metlin.empty_project.user.request.UserListRequest;
import ru.metlin.empty_project.user.response.GetUser;
import ru.metlin.empty_project.user.response.UserList;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private OfficeDao officeDao;
    private DocumentDao documentDao;
    private CountryDao countryDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, OfficeDao officeDao, DocumentDao documentDao, CountryDao countryDao) {
        this.userDao = userDao;
        this.officeDao = officeDao;
        this.documentDao = documentDao;
        this.countryDao = countryDao;
    }

    public UserServiceImpl() {
    }

    public boolean validationByFirstName(String firstName) {
        if (firstName == null) {
            throw new NullPointerException("This user does not exist");
        }

        for (int i = 0; i < firstName.length(); i++) {
            if (firstName.charAt(i) < 'A' || firstName.charAt(i) > 'z' ) {
                throw new InvalidNameException("The name cannot contain symbols");
            }
        }

        for (int i = 0; i < firstName.length(); i++) {
            if (firstName.charAt(i) == ' ') {
                throw new InvalidNameException("The name must not contain spaces");
            }
        }

        return true;
    }

    public boolean validationByPosition(String position) {

        if (position == null) {
            throw new NullPointerException("User should have a position");
        }

        for (int i = 0; i < position.length(); i++) {
            if (position.charAt(i) < 'A' || position.charAt(i) > 'z' ) {
                throw new InvalidNameException("The name cannot contain symbols");
            }
        }

        return true;
    }

    @Override
    @Transactional
    public SuccessView save(SaveUserRequest request) {

        validationByFirstName(request.getFirstName());
        validationByPosition(request.getPosition());

        if (request.getOfficeId() == 0) {
            throw new InvalidValueException("The user does not exist");
        }

        Office office = officeDao.getById(request.getOfficeId());

        if (office == null) {
            throw new NullPointerException("User should have an office");
        }

        if (request.getDocId() == 0) {
            throw new InvalidValueException("The user must have a document");
        }

        Document document = documentDao.getById(request.getDocId());

        if (document == null) {
            throw new NullPointerException("User should have a document");
        }

        if (request.getCountryId() == 0) {
            throw new InvalidValueException("The user must belong to the country");
        }

        Country country = countryDao.getById(request.getCountryId());

        if (country == null) {
            throw new NullPointerException("User should have a country");
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
    public SuccessView update(UpdateUserRequest request) {

        if (request.getId() == 0) {
            throw new InvalidValueException("The user must have an ID");
        }

        validationByFirstName(request.getFirstName());
        validationByPosition(request.getPosition());

        if (request.getOfficeId() == 0) {
            throw new InvalidValueException("The user does not exist");
        }

        Office office = officeDao.getById(request.getOfficeId());

        if (request.getDocId() == 0) {
            throw new InvalidValueException("The user must have a document");
        }

        Document document = documentDao.getById(request.getDocId());

        if (document == null) {
            throw new NullPointerException("The user must have a document");
        }

        if (request.getCountryId() == 0) {
            throw new InvalidValueException("The user must belong to the country");
        }

        Country country = countryDao.getById(request.getCountryId());

        if (country == null) {
            throw new NullPointerException("The user should have a country");
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
    public List<UserList> findAll(UserListRequest request) {

        List<User> userList = userDao.all(request);

        if (userList.isEmpty()) {
            throw new EmptyListException("UserList does not exist");
        }

        List<UserList> userListResponse = new ArrayList<>();

        for (int i = 0; i < userList.size(); i++) {
            userListResponse.add(new UserList(userList.get(i)));
        }

        return userListResponse;
    }

    @Override
    @Transactional
    public GetUser findById(Long id) {

        if (id < 1) {
            throw new InvalidValueException("ID greater than 0");
        }

        User user = userDao.getById(id);

        if (user == null) {
            throw new NullPointerException("The user does not exist");
        }

        return new GetUser(user);
    }
}
