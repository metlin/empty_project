package ru.metlin.empty_project.document.response;

import ru.metlin.empty_project.document.model.Document;

public class DocumentList {

    private Long id;
    private String code;
    private String name;

    public DocumentList(Document document) {
        this.id = document.getDocId();
        this.code = document.getCode();
        this.name = document.getName();
    }

    public DocumentList() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
