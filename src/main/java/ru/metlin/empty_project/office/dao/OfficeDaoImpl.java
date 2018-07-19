package ru.metlin.empty_project.office.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.metlin.empty_project.office.model.Office;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Repository
public class OfficeDaoImpl implements OfficeDao {

    private final EntityManager entityManager;

    @Autowired
    public OfficeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Iterable<Office> all() {
        TypedQuery<Office> query = entityManager.createQuery("SELECT * FROM office", Office.class);
        return query.getResultList();
    }

    @Override
    public Office getById(Long id) {
        return entityManager.find(Office.class, id);
    }

    @Override
    public Office add(Office office) {
        return entityManager.find(Office.class, office);
    }
}
