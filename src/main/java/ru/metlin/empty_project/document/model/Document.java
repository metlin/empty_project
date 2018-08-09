package ru.metlin.empty_project.document.model;

import ru.metlin.empty_project.user.model.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Document {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "doc_id")
    private Long docId;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "code", length = 10, nullable = false)
    private String code;

    @OneToOne
    private User user;

    public Document(Long docId, String name, String code) {
        this.docId = docId;
        this.name = name;
        this.code = code;
    }

    public Document() {
    }

    public Long getUser_id() {
        return docId;
    }

    public void setUser_id(Long user_id) {
        this.docId = user_id;
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
}
