package com.Leman.Service;

import com.Leman.Model.JobApplication;
import com.Leman.Repository.JobApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationService {

    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    // Metoda do pobierania aplikacji użytkownika na podstawie userId
//    public List<JobApplication> getJobApplicationsByUserId(Long userId) {
//        return jobApplicationRepository.findByUserId(userId);
//    }

    // Metoda do pobierania listy użytkowników, którzy aplikowali na konkretną ofertę na podstawie offerId
    public List<JobApplication> getJobApplicationsByOfferId(Long offerId) {
        return jobApplicationRepository.findByOfferId(offerId);
    }

    public JobApplication createJobApplication(JobApplication jobApplication){
        return jobApplicationRepository.save(jobApplication);
    }

}
