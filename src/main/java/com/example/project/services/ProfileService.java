package com.example.project.services;

import com.example.project.databases.Application;
import com.example.project.databases.Profile;
import com.example.project.databases.TravelPlan;
import com.example.project.databases.Visa;
import com.example.project.repositories.ApplicationRepository;
import com.example.project.repositories.ProfileRepository;
import com.example.project.repositories.TravelPlanRepository;
import com.example.project.repositories.VisaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final ApplicationRepository applicationRepository;
    private final TravelPlanRepository travelPlanRepository;
    private final VisaRepository visaRepository;


    @Autowired
    public ProfileService(ProfileRepository profileRepository, ApplicationRepository applicationRepository, TravelPlanRepository travelPlanRepository, VisaRepository visaRepository) {
        this.profileRepository = profileRepository;
        this.applicationRepository = applicationRepository;
        this.travelPlanRepository = travelPlanRepository;
        this.visaRepository = visaRepository;
    }
    public Long saveProfile(Profile profile) {
        Profile savedProfile = profileRepository.save(profile);
        return savedProfile.getIdProfile();
    }
    public void createApplication(Profile profile, Date applicationDate) {
        Application application = new Application();
        application.setProfile(profile);
        application.setApplicationStatus("Обрабатывается");
        application.setSubmitDate(applicationDate);
        applicationRepository.save(application);
    }
    public void createTravelPlan(Profile profile, String destinationCountry, Date entryDate, Integer planStayTimeMonths) {
        TravelPlan travelPlan = new TravelPlan();
        travelPlan.setProfile(profile);
        travelPlan.setDestinationCountry(destinationCountry);
        travelPlan.setPlanStayTimeMonths(planStayTimeMonths);
        travelPlan.setDateDeparture(entryDate);
        travelPlanRepository.save(travelPlan);
    }

    public Long saveVisa(Visa visa) {
        Visa savedVisa = visaRepository.save(visa);
        return savedVisa.getIdVisa();
    }
}