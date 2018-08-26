package ru.metlin.empty_project.response;

public class ErrorView {

    private String error;

    public ErrorView(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
