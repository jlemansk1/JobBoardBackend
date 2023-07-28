package it.yourfirstjob.Leman.Service;



import it.yourfirstjob.Leman.Model.Company;
import it.yourfirstjob.Leman.Model.Offer;
import it.yourfirstjob.Leman.Repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class OfferService {
    @Autowired
    private OfferRepository offerRepository;
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    public Offer createOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    public void deleteOffer(Long offerId) {
        offerRepository.deleteById(offerId);
    }

    public Offer getOfferById(Long offerId) {
        Optional<Offer> optionalOffer = offerRepository.findById(offerId);
        return optionalOffer.orElse(null);
    }

    public Optional<List<Offer>> getOffersByCompany(Company company) {
        return offerRepository.findByCompany(company);
    }


}
