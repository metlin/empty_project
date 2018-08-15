package ru.metlin.empty_project.document.service;

import ru.metlin.empty_project.document.model.Document;
import ru.metlin.empty_project.document.response.DocumentList;

import java.util.List;

public interface DocumentService {

    List<DocumentList> findAll() throws Exception;
}
