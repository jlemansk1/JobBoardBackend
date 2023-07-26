//package it.yourfirstjob.Leman.Model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//
//@Entity
//@Table(name = "users")
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @Column(nullable = false)
//    private String name;
//    private String email;
//    private String phone;
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<JobApplication> jobApplications;
//
//
//}
