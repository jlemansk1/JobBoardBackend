package com.Leman.Repository;


import com.Leman.Model.Company;
import com.Leman.Model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OfferRepository extends JpaRepository<Offer, Long> {
    Optional<List<Offer>> findByCompany(Company company);
}
