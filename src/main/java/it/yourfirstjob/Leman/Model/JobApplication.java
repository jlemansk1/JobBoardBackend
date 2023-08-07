package it.yourfirstjob.Leman.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "jobApplications")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;
    private Timestamp applicationDate;
    private String status;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference(value ="JobApplication-offer")
    @JoinColumn(name = "offer_id", nullable = false)
    private Offer offer;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference(value ="JobApplication-user")
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
