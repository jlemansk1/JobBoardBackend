package it.yourfirstjob.Leman.Repository;

import it.yourfirstjob.Leman.Model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
//    List<JobApplication> findByUserId(Long userId);
    List<JobApplication> findByOfferId(Long offerId);
}
