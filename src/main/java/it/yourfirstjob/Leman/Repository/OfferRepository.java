package it.yourfirstjob.Leman.Repository;


import it.yourfirstjob.Leman.Model.Company;
import it.yourfirstjob.Leman.Model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OfferRepository extends JpaRepository<Offer, Long> {
    Optional<List<Offer>> findByCompany(Company company);
}
