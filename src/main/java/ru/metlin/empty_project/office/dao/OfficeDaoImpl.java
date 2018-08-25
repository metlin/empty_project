package ru.metlin.empty_project.office.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.metlin.empty_project.office.model.Office;
import ru.metlin.empty_project.office.request.OfficeListRequest;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class OfficeDaoImpl implements OfficeDao {

    private final EntityManager entityManager;

    @Autowired
    public OfficeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Office> all(OfficeListRequest office) {
     //   TypedQuery<Office> query = entityManager.createQuery("SELECT o FROM Office o", Office.class);
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Office> offCriteria = cb.createQuery(Office.class);
        Root<Office> offRoot = offCriteria.from(Office.class);

        offCriteria.select(offRoot);

        offCriteria.where(cb.equal(offRoot.get("organization"), office.getOrgId()));
              //  .where(cb.equal(offRoot.get("phone"), office.getPhone()));
     //   offCriteria.where(cb.equal(offRoot.get("name"), office.getName()));

        TypedQuery<Office> query = entityManager.createQuery(offCriteria);

        return query.getResultList();
    }

    @Override
    public Office getById(Long id) {
        return entityManager.find(Office.class, id);
    }

    @Override
    public void add(Office office) {

        entityManager.persist(office);
    }

    @Override
    public void update(Office office) {

        Office updateOffice = entityManager.find(Office.class, office.getId());

        updateOffice.setId(office.getId());
        updateOffice.setName(office.getName());
        updateOffice.setAddress(office.getAddress());
        updateOffice.setPhone(office.getPhone());
        updateOffice.setActive(office.getActive());
        updateOffice.setOrganization(office.getOrganization());
    }
}
