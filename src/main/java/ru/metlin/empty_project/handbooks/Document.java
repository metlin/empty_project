package ru.metlin.empty_project.handbooks;

public class Document {

    Long user_id;
    String name;
    String code;

    public Document(Long user_id, String name, String code) {
        this.user_id = user_id;
        this.name = name;
        this.code = code;
    }

    public Document() {
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
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
