package com.cleto.cinecartaz.controller;

import com.cleto.cinecartaz.model.Cinema;
import com.cleto.cinecartaz.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CinemaService cinemaService;

    @PostMapping(value = "/cinema")
    public ResponseEntity<Object> insertCinema(@RequestBody Cinema cinema){
        cinemaService.saveCinema(cinema);

        Map<String, String> responseObject = new HashMap<>();
        responseObject.put("description", "New Cinema Created");

        return new ResponseEntity<>(responseObject, HttpStatus.CREATED);
    }

    @GetMapping(value = "/cinema/{cinemaId}")
    public ResponseEntity<Object> getCinemaById(@PathVariable long cinemaId){
        System.out.println("CINEMA ID: "+cinemaId);
        return new ResponseEntity<>(cinemaService.getCinemaById(cinemaId), HttpStatus.OK);
    }


}
