package it.yourfirstjob.Leman.Service;

import it.yourfirstjob.Leman.Model.Company;
import it.yourfirstjob.Leman.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CompanyService {
    @Autowired
    private  CompanyRepository companyRepository;

//    @Autowired
//    public CompanyService(CompanyRepository companyRepository) {
//        this.companyRepository = companyRepository;
//    }

    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompanyById(Long companyId) {
        Optional<Company> optionalCompany = companyRepository.findById(companyId);
        return optionalCompany.orElse(null);
    }

    public void deleteCompany(Long companyId) {
        companyRepository.deleteById(companyId);
    }
    public Company findCompanyByName(String name) {
        Optional<Company> optionalCompany = companyRepository.findCompanyByNameAllIgnoringCase(name);
        return optionalCompany.orElse(null);
    }
}

