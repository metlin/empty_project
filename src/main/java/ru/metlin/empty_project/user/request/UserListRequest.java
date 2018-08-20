package ru.metlin.empty_project.user.request;

public class UserListRequest {

    private Long officeId;
    private String firstName;
    private String secondName;
    private String middleName;
    private String position;
 //   private Long docId;
 //   private Long countryId;

    public UserListRequest() {
    }

    public UserListRequest(Long officeId, String firstName, String secondName, String middleName,
                           String position) {
        this.officeId = officeId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
     //   this.docId = docId;
     //   this.countryId = countryId;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

 /*   public Long getDocId() {
        return docId;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    } */
}

