package ru.metlin.empty_project.document.service;

import ru.metlin.empty_project.document.model.Document;

public interface DocumentService {

    Iterable<Document> findAll();
}
