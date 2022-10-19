package com.cleto.cinecartaz.service;

import com.cleto.cinecartaz.model.Cinema;
import com.cleto.cinecartaz.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    public void saveCinema(Cinema cinema){
        cinemaRepository.insert(cinema);
    }

}
