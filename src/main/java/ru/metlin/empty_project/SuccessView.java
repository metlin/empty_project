package ru.metlin.empty_project;

public class SuccessView {

    private String result = "success";
    private String error;

    public SuccessView(String error) {
        this.error = error;
    }

    public SuccessView() {
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
