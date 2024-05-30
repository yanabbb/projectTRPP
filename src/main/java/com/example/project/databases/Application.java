package com.example.project.databases;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "applications")
public class Application {
    @Id
    private Long idProfile;

    @OneToOne
    @MapsId
    @JoinColumn(name = "idProfile")
    private Profile profile;

    private String applicationStatus;
    private Date submitDate;

    public void setIdProfile(Long idProfile) {
        this.idProfile = idProfile;
    }

    public Long getIdProfile() {
        return idProfile;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }
    public Application(){}
}