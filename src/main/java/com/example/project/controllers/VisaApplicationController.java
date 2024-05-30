package com.example.project.controllers;

import com.example.project.databases.Profile;
import com.example.project.databases.Visa;
import com.example.project.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class VisaApplicationController {

    private final ProfileService profileService;

    @Autowired
    public VisaApplicationController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/")
    public String index(Model model){
        return "index";
    }

    @PostMapping("/index")
    public String submitVisaApplication(@RequestParam("fullName") String fullName,
                                        @RequestParam("passportNumber") String passportNumber,
                                        @RequestParam("dob") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dob,
                                        @RequestParam("gender") String gender,
                                        @RequestParam("citizenship") String citizenship,
                                        @RequestParam("visaType") String visaType,
                                        @RequestParam("destinationCountry") String destinationCountry,
                                        @RequestParam("entryDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date entryDate,
                                        @RequestParam("planStayTimeMonths") Integer planStayTimeMonths,
                                        @RequestParam("applicationDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date applicationDate){
        // Создаем визу
        Visa visa = new Visa();
        visa.setVisaType(visaType);
        Long visaId = profileService.saveVisa(visa);

        // Создаем новый профиль
        Profile profile = new Profile();
        profile.setFullName(fullName);
        profile.setPassport(passportNumber);
        profile.setDateBirth(dob);
        profile.setSex(gender);
        profile.setNationality(citizenship);
        profile.setVisa(visa);
        Long profileId = profileService.saveProfile(profile);

        // Создаем заявление, план поездки и визу
        profileService.createApplication(profile, applicationDate);
        profileService.createTravelPlan(profile, destinationCountry, entryDate, planStayTimeMonths);

        return "index"; // Перенаправление на страницу успешной отправки
    }
}
