package ru.metlin.empty_project.document.dao;

import ru.metlin.empty_project.document.model.Document;

public interface DocumentDao {

    Iterable<Document> all();

    Document getById(Long id);
}
