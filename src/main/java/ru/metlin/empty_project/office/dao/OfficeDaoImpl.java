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

        entityManager.persist(office);

        return successView;
    }

    @Override
    public SuccessView update(Office office) {
        SuccessView successView = new SuccessView();

        Office updateOffice = entityManager.find(Office.class, office.getId());

        updateOffice.setId(office.getId());
        updateOffice.setName(office.getName());
        updateOffice.setAddress(office.getAddress());
        updateOffice.setPhone(office.getPhone());
        updateOffice.setActive(office.getActive());
        updateOffice.setOrganization(office.getOrganization());

        return successView;
    }
}
