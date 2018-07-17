package ru.metlin.empty_project.office.model;

import org.springframework.data.repository.CrudRepository;

public interface OfficeRepository extends CrudRepository<Office, Long> {

    public Iterable<Office> findByOrgId(Long orgId);
}

