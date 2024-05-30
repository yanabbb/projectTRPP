package com.example.project.databases;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfile;

    private String fullName;
    private String passport;
    private Date dateBirth;
    private String sex;
    private String nationality;

    @ManyToOne
    @JoinColumn(name = "idVisa")
    private Visa visa;

    @OneToOne(mappedBy = "profile")
    private Application application;

    @OneToOne(mappedBy = "profile")
    private TravelPlan travelPlan;
    public Long getIdProfile() {
        return idProfile;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public String getFullName() {
        return fullName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setIdProfile(Long idProfile) {
        this.idProfile = idProfile;
    }

    public String getPassport() {
        return passport;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getSex() {
        return sex;
    }

    public Visa getVisa() {
        return visa;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setVisa(Visa visa) {
        this.visa = visa;
    }
    public Profile(){}
}
