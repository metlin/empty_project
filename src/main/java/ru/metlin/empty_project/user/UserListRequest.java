package ru.metlin.empty_project.user;

public class UserListRequest {

    private Long officeId;
    private String firstName;
    private String secondName;
    private String middleName;
    private String position;
    private Long docDate;
    private Long sitizenshipCode;

    public UserListRequest(Long officeId, String firstName, String secondName, String middleName,
                           String position, Long docDate, Long sitizenshipCode) {
        this.officeId = officeId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
        this.docDate = docDate;
        this.sitizenshipCode = sitizenshipCode;
    }

    public UserListRequest() {
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

    public Long getDocDate() {
        return docDate;
    }

    public void setDocDate(Long docDate) {
        this.docDate = docDate;
    }

    public Long getSitizenshipCode() {
        return sitizenshipCode;
    }

    public void setSitizenshipCode(Long sitizenshipCode) {
        this.sitizenshipCode = sitizenshipCode;
    }
}

