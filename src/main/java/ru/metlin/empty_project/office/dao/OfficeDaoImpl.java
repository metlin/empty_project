package ru.metlin.empty_project.office.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.metlin.empty_project.SuccessView;
import ru.metlin.empty_project.office.model.Office;
import ru.metlin.empty_project.office.request.UpdateOfficeRequest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
        TypedQuery<Office> query = entityManager.createQuery("SELECT o FROM Office o", Office.class);
        return query.getResultList();
    }

    @Override
    public Office getById(Long id) {
        return entityManager.find(Office.class, id);
    }

    @Override
    public SuccessView add(Office office) {
        SuccessView successView = new SuccessView();

        if (office.getId() == null) {
           entityManager.persist(office);
       } else {
           Office off = entityManager.find(Office.class, office.getId());
           off.setName(office.getName());
           off.setActive(office.getActive());
           off.setOrgId(office.getOrgId());
           off.setAddress(office.getAddress());
           off.setId(office.getId());
           off.setPhone(office.getPhone());

           entityManager.persist(off);
       }

       return successView;
    }
}
