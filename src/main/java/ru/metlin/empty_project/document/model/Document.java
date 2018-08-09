package ru.metlin.empty_project.document.model;

import ru.metlin.empty_project.user.model.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Document")
public class Document {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "doc_id")
    private Long docId;

    @Column(name = "doc_name", length = 50, nullable = false)
    private String name;

    @Column(name = "doc_code", length = 10, nullable = false)
    private String code;

    @OneToOne(mappedBy = "document")
    private User user;

    public Document(Long docId, String name, String code) {
        this.docId = docId;
        this.name = name;
        this.code = code;
    }

    public Document() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getDocId() {
        return docId;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
