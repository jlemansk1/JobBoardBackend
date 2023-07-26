package it.yourfirstjob.Leman.Repository;

import it.yourfirstjob.Leman.Model.Company;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findCompanyByNameAllIgnoringCase(String name);
}
