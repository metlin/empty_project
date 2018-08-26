package ru.metlin.empty_project.document.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.metlin.empty_project.document.dao.DocumentDao;
import ru.metlin.empty_project.document.model.Document;
import ru.metlin.empty_project.document.view.DocumentList;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentDao documentDao;

    @Autowired
    DocumentServiceImpl(DocumentDao documentDao) {
        this.documentDao = documentDao;
    }

    @Override
    @Transactional
    public List<DocumentList> findAll() {
        List<Document> docList = documentDao.all();

        if (docList == null) {
            throw new NullPointerException("Document list does not exist");
        }

        List<DocumentList> docListResponse = new ArrayList<>();

        for (int i = 0; i < docList.size(); i++) {
            docListResponse.add(new DocumentList(docList.get(i)));
        }

        return docListResponse;
    }
}
