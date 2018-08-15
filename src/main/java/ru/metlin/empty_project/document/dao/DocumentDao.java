package ru.metlin.empty_project.document.dao;

import ru.metlin.empty_project.document.model.Document;

import java.util.List;

public interface DocumentDao {

    List<Document> all();

    Document getById(Long id);
}
