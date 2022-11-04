package com.cleto.cinecartaz.service;

import com.cleto.cinecartaz.model.Cinema;
import com.cleto.cinecartaz.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;


    public void saveCinema(Cinema cinema){
        cinema.setId((int) sequenceGeneratorService.generateSequence(Cinema.SEQUENCE_NAME));
        cinemaRepository.insert(cinema);
    }

    public Optional<Cinema> getCinemaById(long cinemaId) {
        return Optional.ofNullable(cinemaRepository.findCinemaById(cinemaId));
    }

    public List<Cinema> getCinemasByNameCompanyLocationOrCounty(String name, String company, String county, String location) {
        Query dynamicQuery = new Query();
        if (!name.equals("NONE")) {
            Criteria nameCriteria = Criteria.where("name").is(name);
            dynamicQuery.addCriteria(nameCriteria);
        }
        if (!company.equals("NONE")) {
            Criteria nameCriteria = Criteria.where("company").is(company);
            dynamicQuery.addCriteria(nameCriteria);
        }
        if (!county.equals("NONE")) {
            Criteria nameCriteria = Criteria.where("county").is(county);
            dynamicQuery.addCriteria(nameCriteria);
        }
        if (!location.equals("NONE")) {
            Criteria nameCriteria = Criteria.where("location").is(location);
            dynamicQuery.addCriteria(nameCriteria);
        }
        List<Cinema> cinemas = mongoTemplate.find(dynamicQuery.with(Sort.by(Sort.Direction.ASC,"name")), Cinema.class, "cinemas");
        return cinemas;
    }

    public void deleteCinemaById(long cinemaId) {
        cinemaRepository.deleteById(cinemaId);
    }

    public void updateCinema(Cinema cinema) {
        if (cinemaRepository.findById(cinema.getId()).isEmpty()) {
            throw new IllegalArgumentException("No Cinema Matching");

        } else {
            Query dynamicQuery = new Query();
            dynamicQuery.addCriteria(new Criteria().andOperator(Criteria.where("id").is(cinema.getId())));
            Update updateDefinition = new Update().set("company", cinema.getCompany()).set("location", cinema.getLocation()).set("name", cinema.getCompany() + cinema.getLocation());

            mongoTemplate.findAndModify(dynamicQuery, updateDefinition, Cinema.class);
        }
    }

}
