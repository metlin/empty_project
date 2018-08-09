package ru.metlin.empty_project.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.metlin.empty_project.SuccessView;
import ru.metlin.empty_project.user.model.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
            this.entityManager = entityManager;
        }


    @Override
    public Iterable<User> all() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Override
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public SuccessView add(User user) {

        SuccessView successView = new SuccessView();

        entityManager.persist(user);

        return successView;
    }

    @Override
    public SuccessView update(User user) {
        SuccessView successView = new SuccessView();

        User updateUser = entityManager.find(User.class, user.getId());

        updateUser.setFirstName(user.getFirstName());
        updateUser.setSecondName(user.getSecondName());
        updateUser.setMiddleName(user.getMiddleName());
        updateUser.setPhone(user.getPhone());
        updateUser.setPosition(user.getPosition());
        updateUser.setIdentified(user.getIdentified());

        return successView;
    }
}
