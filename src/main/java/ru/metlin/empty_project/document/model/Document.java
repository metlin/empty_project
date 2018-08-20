package ru.metlin.empty_project.document.model;

import ru.metlin.empty_project.user.model.User;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

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

    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<User> userList;

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

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
