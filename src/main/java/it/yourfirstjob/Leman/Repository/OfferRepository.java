package it.yourfirstjob.Leman.Repository;

import it.yourfirstjob.Leman.Model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}
