package ru.metlin.empty_project.document.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.metlin.empty_project.document.service.DocumentService;
import ru.metlin.empty_project.document.view.DocumentList;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class DocumentController {

    private final DocumentService documentService;

    @Autowired
    DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

   @PostMapping(value = "/docs")
    private List<DocumentList> getDocumentsList() {

        return documentService.findAll();
    }
}
