package com.example.project.databases;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "visas")
public class Visa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVisa;
    private String visaType;
    @OneToMany(mappedBy = "visa")
    private List<Profile> profiles;
    public Long getIdVisa() {
        return idVisa;
    }
    public void setIdVisa(Long idVisa) {
        this.idVisa = idVisa;
    }
    public String getVisaType() {
        return visaType;
    }
    public void setVisaType(String visaType) {
        this.visaType = visaType;
    }
    public Visa(){}
}