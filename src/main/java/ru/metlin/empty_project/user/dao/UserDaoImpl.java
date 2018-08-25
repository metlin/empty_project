package ru.metlin.empty_project.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.metlin.empty_project.user.model.User;
import ru.metlin.empty_project.user.request.UserListRequest;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
            this.entityManager = entityManager;
        }


    @Override
    public List<User> all(UserListRequest user) {
      //  TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<User> userCriteria = cb.createQuery(User.class);
        Root<User> userRoot = userCriteria.from(User.class);

        userCriteria.select(userRoot);
        userCriteria.where(cb.equal(userRoot.get("office"), user.getOfficeId()));

        TypedQuery<User> query = entityManager.createQuery(userCriteria);

        return query.getResultList();
    }

    @Override
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void add(User user) {

        entityManager.persist(user);
    }

    @Override
    public void update(User user) {

        User updateUser = entityManager.find(User.class, user.getId());

        updateUser.setId(user.getId());
        updateUser.setFirstName(user.getFirstName());
        updateUser.setSecondName(user.getSecondName());
        updateUser.setMiddleName(user.getMiddleName());
        updateUser.setPhone(user.getPhone());
        updateUser.setPosition(user.getPosition());
        updateUser.setIdentified(user.getIdentified());
        updateUser.setCountry(user.getCountry());
        updateUser.setOffice(user.getOffice());
        updateUser.setDocument(user.getDocument());
    }
}
