package ru.metlin.empty_project.organization.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.metlin.empty_project.SuccessView;
import ru.metlin.empty_project.organization.model.Organization;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Repository
public class OrganizationDaoImpl implements OrganizationDao {

    private final EntityManager entityManager;

    @Autowired
    public OrganizationDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Iterable<Organization> all() {
        TypedQuery<Organization> query = entityManager.createQuery("SELECT o FROM Organization o", Organization.class);
        return query.getResultList();
    }

    @Override
    public Organization getById(Long id) {
        return entityManager.find(Organization.class, id);
    }

    @Override
    public SuccessView add(Organization organization) {
        SuccessView successView = new SuccessView();

        if (organization.getId() == null) {
            entityManager.persist(organization);
        } else {
            Organization org = entityManager.find(Organization.class, organization.getId());
            org.setName(organization.getName());
            org.setActive(organization.getActive());
            org.setAddress(organization.getAddress());
            org.setId(organization.getId());
            org.setPhone(organization.getPhone());

        //    entityManager.persist(org);
        }

        return successView;
    }
}
