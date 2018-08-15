package ru.metlin.empty_project.document.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.metlin.empty_project.document.model.Document;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class DocumentDaoImpl implements DocumentDao {

    private final EntityManager entityManager;

    @Autowired
    DocumentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Document> all() {
        TypedQuery<Document> query = entityManager.createQuery("SELECT d FROM Document d", Document.class);
        return query.getResultList();
    }

    @Override
    public Document getById(Long id) {
        return entityManager.find(Document.class, id);
    }
}
