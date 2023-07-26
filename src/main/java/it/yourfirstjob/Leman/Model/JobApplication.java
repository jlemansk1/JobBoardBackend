//package it.yourfirstjob.Leman.Model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.security.Timestamp;
//import java.util.List;
//
//@Entity
//@Table(name = "jobApplications")
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//public class JobApplication {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long applicationId;
//    private Timestamp applicationDate;
//    private String status;
//
//    @ManyToOne
//    @JoinColumn(name = "offer_id", nullable = false)
//    private Offer offer;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
//
//}
