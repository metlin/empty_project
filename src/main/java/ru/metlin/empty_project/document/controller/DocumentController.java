package ru.metlin.empty_project.document.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.metlin.empty_project.document.model.Document;
import ru.metlin.empty_project.document.service.DocumentService;

@RestController
@RequestMapping(value = "/api")
public class DocumentController {

    private final DocumentService documentService;

    @Autowired
    DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping(value = "/docs")
    private Iterable<Document> getDocumentsList() {
        return documentService.findAll();
    }

}
