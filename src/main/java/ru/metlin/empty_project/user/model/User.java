package ru.metlin.empty_project.user.model;

import ru.metlin.empty_project.country.model.Country;
import ru.metlin.empty_project.document.model.Document;
import ru.metlin.empty_project.office.model.Office;
import ru.metlin.empty_project.user.request.SaveUserRequest;
import ru.metlin.empty_project.user.request.UpdateUserRequest;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "second_name", length = 50, nullable = false)
    private String secondName;

    @Column(name = "middle_name", length = 50, nullable = false)
    private String middleName;

    @Column(name = "position", length = 50, nullable = false)
    private String position;

    @Column(name = "doc_number", length = 30, nullable = false)
    private Long docNumber;

    @Column(name = "doc_date", length = 10, nullable = false)
    private Date docDate;

    @Column(name = "phone", length = 50, nullable = false)
    private String phone;

    @Column(name = "identified", length = 50, nullable = false)
    private Boolean isIdentified;

    @ManyToOne
    @JoinColumn(name = "office_id", nullable = false)
    private Office office;

    @ManyToOne
    @JoinColumn(name = "doc_id", nullable = false)
    private Document document;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    public User(Long id, String firstName, String secondName, String middleName, String position,
                String phone, Boolean isIdentified, Date docDate, Long docNumber) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
        this.phone = phone;
        this.isIdentified = isIdentified;
        this.docDate = docDate;
        this.docNumber = docNumber;
    }

    public User() {
    }

    public User(SaveUserRequest request) {
        this.firstName = request.getFirstName();
        this.secondName = request.getSecondName();
        this.middleName = request.getMiddleName();
        this.position = request.getPosition();
        this.phone = request.getPhone();
        this.isIdentified = request.getIdentified();
        this.docDate = request.getDocDate();
        this.docNumber = request.getDocNumber();
    }

    public User(UpdateUserRequest request) {
        this.id = request.getId();
        this.firstName = request.getFirstName();
        this.secondName = request.getSecondName();
        this.middleName = request.getMiddleName();
        this.position = request.getPosition();
        this.phone = request.getPhone();
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

    public Boolean getIdentified() {
        return isIdentified;
    }

    public void setIdentified(Boolean identified) {
        isIdentified = identified;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Long getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(Long docNumber) {
        this.docNumber = docNumber;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }
}
