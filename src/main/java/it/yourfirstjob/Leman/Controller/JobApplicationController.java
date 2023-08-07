package it.yourfirstjob.Leman.Controller;


import it.yourfirstjob.Leman.Model.JobApplication;
import it.yourfirstjob.Leman.Service.JobApplicationService;
import it.yourfirstjob.Leman.Service.OfferService;
import it.yourfirstjob.Leman.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.sql.Timestamp;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/jobapplications")
public class JobApplicationController {
    @Autowired
    private JobApplicationService jobApplicationService;
    @Autowired
    private OfferService offerService;
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<JobApplication> postJobApplication(@RequestBody JobApplicationRequest request) {
        Long offerId = request.getOfferId();
        Long userId = request.getUserId();
        JobApplication jobApplication = new JobApplication();
        jobApplication.setApplicationDate(request.getApplicationDate());
        jobApplication.setStatus(request.getStatus());

        // Pobieramy ofertę na podstawie przekazanego offerId
        // Jeśli oferta o podanym ID nie istnieje, zwracamy błąd BAD_REQUEST
        jobApplication.setOffer(offerService.getOfferById(offerId));
        if (jobApplication.getOffer() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        jobApplication.setUser(userService.getUserById(userId));
        if (jobApplication.getUser() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // Dodajemy nową aplikację na stanowisko pracy
        JobApplication createdJobApplication = jobApplicationService.createJobApplication(jobApplication);
        return new ResponseEntity<>(createdJobApplication, HttpStatus.CREATED);
    }

//    // Endpoint do pobierania aplikacji użytkownika na podstawie userId
//    @GetMapping("/user/{userId}")
//    public ResponseEntity<List<JobApplication>> getJobApplicationsByUserId(@PathVariable Long userId) {
//        List<JobApplication> jobApplications = jobApplicationService.getJobApplicationsByUserId(userId);
//        return new ResponseEntity<>(jobApplications, HttpStatus.OK);
//    }

    // Endpoint do pobierania listy użytkowników, którzy aplikowali na konkretną ofertę na podstawie offerId
    @GetMapping("/{offerId}")
    public ResponseEntity<List<JobApplication>> getJobApplicationsByOfferId(@PathVariable Long offerId) {
        List<JobApplication> jobApplications = jobApplicationService.getJobApplicationsByOfferId(offerId);
        return new ResponseEntity<>(jobApplications, HttpStatus.OK);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    // Klasa pomocnicza, reprezentująca żądanie tworzenia aplikacji
    private static class JobApplicationRequest {
        private Timestamp applicationDate;
        private String status;
        private Long offerId;
        private Long userId;
    }
}
