package ru.metlin.empty_project.handbooks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class HandbookController {

    private final HandbookService handbookService;

    @Autowired
    HandbookController(HandbookService handbookService) {
        this.handbookService = handbookService;
    }

    @PostMapping(value = "/docs")
    private Iterable<Document> getDocumentsList() {
        return handbookService.findAll();
    }

}
