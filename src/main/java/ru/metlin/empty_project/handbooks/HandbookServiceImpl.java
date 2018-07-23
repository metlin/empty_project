package ru.metlin.empty_project.handbooks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class HandbookServiceImpl implements HandbookService{

    private final HandbookDao handbookDao;

    @Autowired
    HandbookServiceImpl(HandbookDao handbookDao) {
        this.handbookDao = handbookDao;
    }

    @Override
    @Transactional
    public Iterable<Document> findAll() {
        return handbookDao.all();
    }
}
