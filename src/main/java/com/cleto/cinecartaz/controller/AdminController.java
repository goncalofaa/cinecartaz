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
    public ResponseEntity<Object> insert(@RequestBody Cinema cinema){
        cinemaService.saveCinema(cinema);

        Map<String, String> responseObject = new HashMap<>();
        responseObject.put("description", "New Cinema Created");

        return new ResponseEntity<>(responseObject, HttpStatus.CREATED);
    }
}
