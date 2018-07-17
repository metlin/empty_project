package ru.metlin.empty_project.user.model;

import ru.metlin.empty_project.user.request.SaveUserRequest;
import ru.metlin.empty_project.user.request.UpdateUserRequest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String secondName;
    private String middleName;
    private String position;
    private String phone;
    private String docName;
    private Long officeId;
    private Long docNumber;
    private Long docDate;
    private Long docCode;
    private String sitizenshipName;
    private Long sitizenshipCode;
    private Boolean isIdentified;

    public User(Long id, String firstName, String secondName, String middleName, String position, String phone, String docName, Long officeId, Long docNumber, Long docDate, Long docCode, String sitizenshipName,
                Long sitizenshipCode, Boolean isIdentified) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
        this.phone = phone;
        this.docName = docName;
        this.officeId = officeId;
        this.docNumber = docNumber;
        this.docDate = docDate;
        this.docCode = docCode;
        this.sitizenshipName = sitizenshipName;
        this.sitizenshipCode = sitizenshipCode;
        this.isIdentified = isIdentified;
    }

    public User() {
    }

    public User(SaveUserRequest request) {
        this.firstName = request.getFirstName();
        this.secondName = request.getSecondName();
        this.middleName = request.getSecondName();
        this.position = request.getPosition();
        this.phone = request.getPhone();
        this.docName = request.getDocName();
        this.docNumber = request.getDocNumber();
        this.docDate = request.getDocDate();
        this.sitizenshipCode = request.getSitizenshipCode();
        this.isIdentified = request.getIdentified();
    }

    public User(UpdateUserRequest request) {
        this.id = request.getId();
        this.firstName = request.getFirstName();
        this.secondName = request.getSecondName();
        this.middleName = request.getMiddleName();
        this.position = request.getPosition();
        this.phone = request.getPhone();
        this.docName = request.getDocName();
        this.docNumber = request.getDocNumber();
        this.docDate = request.getDocDate();
        this.sitizenshipCode = request.getSitizenshipCode();
        this.isIdentified = request.getIdentified();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public Long getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(Long docNumber) {
        this.docNumber = docNumber;
    }

    public Long getDocDate() {
        return docDate;
    }

    public void setDocDate(Long docDate) {
        this.docDate = docDate;
    }

    public Long getDocCode() {
        return docCode;
    }

    public void setDocCode(Long docCode) {
        this.docCode = docCode;
    }

    public String getSitizenshipName() {
        return sitizenshipName;
    }

    public void setSitizenshipName(String sitizenshipName) {
        this.sitizenshipName = sitizenshipName;
    }

    public Long getSitizenshipCode() {
        return sitizenshipCode;
    }

    public void setSitizenshipCode(Long sitizenshipCode) {
        this.sitizenshipCode = sitizenshipCode;
    }

    public Boolean getIdentified() {
        return isIdentified;
    }

    public void setIdentified(Boolean identified) {
        isIdentified = identified;
    }
}
