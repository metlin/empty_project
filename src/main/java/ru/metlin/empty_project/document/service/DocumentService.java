package ru.metlin.empty_project.document.service;

import ru.metlin.empty_project.document.view.DocumentList;

import java.util.List;

public interface DocumentService {

    List<DocumentList> findAll();
}
