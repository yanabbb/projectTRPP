package com.example.project.databases;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "travel_plans")
public class TravelPlan {
    @Id
    private Long idProfile;

    @OneToOne
    @MapsId
    @JoinColumn(name = "idProfile")
    private Profile profile;

    private String destinationCountry;
    private Integer planStayTimeMonths;
    private Date dateDeparture;

    public Profile getProfile() {
        return profile;
    }

    public Long getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(Long idProfile) {
        this.idProfile = idProfile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Date getDateDeparture() {
        return dateDeparture;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public Integer getPlanStayTimeMonths() {
        return planStayTimeMonths;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDateDeparture(Date dateDeparture) {
        this.dateDeparture = dateDeparture;
    }

    public void setPlanStayTimeMonths(Integer planStayTimeMonths) {
        this.planStayTimeMonths = planStayTimeMonths;
    }
    public TravelPlan(){}
}