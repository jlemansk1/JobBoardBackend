package it.yourfirstjob.Leman.Controller;

import it.yourfirstjob.Leman.Model.Company;
import it.yourfirstjob.Leman.Model.Offer;
import it.yourfirstjob.Leman.Service.CompanyService;
import it.yourfirstjob.Leman.Service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/offers")
public class OfferController {
    @Autowired
    private OfferService offerService;
    @Autowired
    private CompanyService companyService;
    @GetMapping
    public ResponseEntity<List<Offer>> getAllOffers() {
        return new ResponseEntity<List<Offer>>(offerService.getAllOffers(), HttpStatus.OK);
    }

    @PostMapping("/addoffer")
    public ResponseEntity<Offer> createOffer(@RequestBody OfferRequest offerRequest) {
        Long companyId = offerRequest.getCompanyId();
        Company company = null;
        System.out.println("Dziala");
        // Sprawdzamy, czy przekazano obiekt firmy (czy company != null)
        // Obsługa błędu - brak obiektu firmy w żądaniu
        if (companyId != null) {
            // Wyszukujemy firmę na podstawie przekazanego ID
            company = companyService.getCompanyById(companyId);
        } else {
            // Jeżeli companyId == null, oznacza to, że przekazano pełen obiekt firmy w żądaniu
            // Możesz wtedy skorzystać z obiektu firmy przekazanego w żądaniu
            company = offerRequest.getCompany();
        }
        if (company == null) {
            // Obsługa błędu - brak firmy o podanym ID
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


        // Tworzymy nowy obiekt oferty
        Offer newOffer = new Offer();
        newOffer.setJobTittle(offerRequest.getJobTitle());
        newOffer.setJobLocation(offerRequest.getJobLocation());
        // Przypisujemy firmę do oferty
        newOffer.setCompany(company);
        System.out.println("Dziala2");
        // Zapisujemy nową ofertę w bazie danych
        Offer createdOffer = offerService.createOffer(newOffer);
        System.out.println("Dziala3");
        return new ResponseEntity<>(createdOffer, HttpStatus.CREATED);
    }


    @GetMapping("/{offerId}")
    public ResponseEntity<Offer> getOfferById(@PathVariable Long offerId) {
        Offer offer = offerService.getOfferById(offerId);
        if (offer != null) {
            return new ResponseEntity<>(offer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{offerId}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long offerId) {
        offerService.deleteOffer(offerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
//    @AllArgsConstructor
//    @NoArgsConstructor
    //@Data
    // Klasa pomocnicza, reprezentująca żądanie tworzenia oferty
    private static class OfferRequest {
        private String jobTitle;
        private String jobLocation;
        private Long companyId;
        private Company company; // Dodajemy również pole company typu Company

        public String getJobTitle() {
            return jobTitle;
        }

        public void setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
        }

        public String getJobLocation() {
            return jobLocation;
        }

        public void setJobLocation(String jobLocation) {
            this.jobLocation = jobLocation;
        }

        public Long getCompanyId() {
            return companyId;
        }

        public void setCompanyId(Long companyId) {
            this.companyId = companyId;
        }

        public Company getCompany() {
            return company;
        }

        public void setCompany(Company company) {
            this.company = company;
        }
    }


}




