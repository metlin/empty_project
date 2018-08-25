package ru.metlin.empty_project.document.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.metlin.empty_project.document.service.DocumentService;

@RestController
@RequestMapping(value = "/api")
public class DocumentController {

    private final DocumentService documentService;

    @Autowired
    DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

  /*  @PostMapping(value = "/docs")
    private Response<List<DocumentList>> getDocumentsList() {
        try {
            return new Response<List<DocumentList>>(documentService.findAll());
        } catch (Exception e) {
            return new Response<List<DocumentList>>(e.getMessage());
        }
    } */
}
