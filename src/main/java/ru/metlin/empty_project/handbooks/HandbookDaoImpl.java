package ru.metlin.empty_project.handbooks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Repository
public class HandbookDaoImpl implements HandbookDao{

    private final EntityManager entityManager;

    @Autowired
    HandbookDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Iterable<Document> all() {
        TypedQuery<Document> query = entityManager.createQuery("SELECT d FROM Document d", Document.class);
        return query.getResultList();
    }
}
