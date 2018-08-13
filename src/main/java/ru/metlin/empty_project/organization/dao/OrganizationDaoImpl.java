package ru.metlin.empty_project.organization.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.metlin.empty_project.SuccessView;
import ru.metlin.empty_project.organization.model.Organization;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OrganizationDaoImpl implements OrganizationDao {

    private final EntityManager entityManager;

    @Autowired
    public OrganizationDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Organization> all() {
        TypedQuery<Organization> query = entityManager.createQuery("SELECT o FROM Organization o", Organization.class);

        return query.getResultList();
    }

    @Override
    public Organization getById(Long id) {
        return entityManager.find(Organization.class, id);
    }

    @Override
    public void add(Organization organization) {

        entityManager.persist(organization);
    }

    @Override
    public void update(Organization organization) {

        Organization updateOrg = entityManager.find(Organization.class, organization.getId());

        updateOrg.setId(organization.getId());
        updateOrg.setName(organization.getName());
        updateOrg.setAddress(organization.getAddress());
        updateOrg.setFullName(organization.getFullName());
        updateOrg.setActive(organization.getActive());
        updateOrg.setPhone(organization.getPhone());
        updateOrg.setInn(organization.getInn());
        updateOrg.setKpp(organization.getKpp());
    }
}
