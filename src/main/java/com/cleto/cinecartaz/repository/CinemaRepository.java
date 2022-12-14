package com.cleto.cinecartaz.repository;

import com.cleto.cinecartaz.model.Cinema;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CinemaRepository extends MongoRepository <Cinema, Long>{

    Cinema findCinemaById(long id);

}
