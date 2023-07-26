package it.yourfirstjob.Leman.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "offers")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "job_tittle")
    private String jobTittle;
    @Column(name = "job_Location")
    private String jobLocation;
//    @OneToMany(mappedBy = "offer", cascade = CascadeType.ALL)
//    private List<JobApplication> jobApplications;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;



}
