//package it.yourfirstjob.Leman.Controller;
//
//import it.yourfirstjob.Leman.Model.JobApplication;
//import it.yourfirstjob.Leman.Model.User;
//import it.yourfirstjob.Leman.Service.JobApplicationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@CrossOrigin(origins = "*")
//@RestController
//@RequestMapping("/api/v1/jobapplications")
//public class JobApplicationController {
//    @Autowired
//    private JobApplicationService jobApplicationService;
//
//    @PostMapping
//    public ResponseEntity<JobApplication>
//
//    // Endpoint do pobierania aplikacji użytkownika na podstawie userId
//    @GetMapping("/user/{userId}")
//    public ResponseEntity<List<JobApplication>> getJobApplicationsByUserId(@PathVariable Long userId) {
//        List<JobApplication> jobApplications = jobApplicationService.getJobApplicationsByUserId(userId);
//        return new ResponseEntity<>(jobApplications, HttpStatus.OK);
//    }
//
//    // Endpoint do pobierania listy użytkowników, którzy aplikowali na konkretną ofertę na podstawie offerId
//    @GetMapping("/company/{offerId}")
//    public ResponseEntity<List<JobApplication>> getJobApplicationsByOfferId(@PathVariable Long offerId) {
//        List<JobApplication> jobApplications = jobApplicationService.getJobApplicationsByOfferId(offerId);
//        return new ResponseEntity<>(jobApplications, HttpStatus.OK);
//    }
//}
