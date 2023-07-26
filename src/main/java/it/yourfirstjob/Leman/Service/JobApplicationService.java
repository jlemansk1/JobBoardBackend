//package it.yourfirstjob.Leman.Service;
//
//import it.yourfirstjob.Leman.Model.JobApplication;
//import it.yourfirstjob.Leman.Model.User;
//import it.yourfirstjob.Leman.Repository.JobApplicationRepository;
//import it.yourfirstjob.Leman.Repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class JobApplicationService {
//    private JobApplicationRepository jobApplicationRepository;
//    private UserRepository userRepository;
//
//    @Autowired
//    public JobApplicationService(JobApplicationRepository jobApplicationRepository, UserRepository userRepository) {
//        this.jobApplicationRepository = jobApplicationRepository;
//        this.userRepository = userRepository;
//    }
//
//    // Metoda do pobierania aplikacji użytkownika na podstawie userId
//    public List<JobApplication> getJobApplicationsByUserId(Long userId) {
//        return jobApplicationRepository.findByUserId(userId);
//    }
//
//    // Metoda do pobierania listy użytkowników, którzy aplikowali na konkretną ofertę na podstawie offerId
//    public List<JobApplication> getJobApplicationsByOfferId(Long offerId) {
//        return jobApplicationRepository.findByOfferId(offerId);
//    }
//
//}
