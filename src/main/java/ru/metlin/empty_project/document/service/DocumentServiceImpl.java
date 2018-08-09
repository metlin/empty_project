package ru.metlin.empty_project.document.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.metlin.empty_project.document.dao.DocumentDao;
import ru.metlin.empty_project.document.model.Document;

import javax.transaction.Transactional;

@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentDao documentDao;

    @Autowired
    DocumentServiceImpl(DocumentDao documentDao) {
        this.documentDao = documentDao;
    }

    @Override
    @Transactional
    public Iterable<Document> findAll() {
        return documentDao.all();
    }
}
