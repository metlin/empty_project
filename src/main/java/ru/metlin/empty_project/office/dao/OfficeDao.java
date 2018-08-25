package ru.metlin.empty_project.office.dao;

import ru.metlin.empty_project.office.model.Office;
import ru.metlin.empty_project.office.request.OfficeListRequest;

import java.util.List;

public interface OfficeDao {

    void add(Office office);

    void update(Office office);

    List<Office> all(OfficeListRequest office);

    Office getById(Long id);
}
