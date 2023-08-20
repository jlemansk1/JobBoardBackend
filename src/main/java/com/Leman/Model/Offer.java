package com.Leman.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private List<String> location;
//    @OneToMany(mappedBy = "offer", cascade = CascadeType.ALL)
//    private List<JobApplication> jobApplications;
    private Seniority seniority;
    private boolean isRemote;
    private String logoLink;
    private SalaryRange salaryRange;
    private List<String> requiredTechnologies;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference(value ="offer-company")
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
    private List<String> sampleTasks;
    private List<String> requirements;
    private List<String> benefits;

}
