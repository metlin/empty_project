package ru.metlin.empty_project.office.dao;

import ru.metlin.empty_project.office.model.Office;

import java.util.Optional;

public interface OfficeDao {

    Office add(Office office);

    Iterable<Office> all();

    Office getById(Long id);
}
