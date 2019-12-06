package com.zipcodewilmington.bakery.controllers;

import com.zipcodewilmington.bakery.models.Baker;
import com.zipcodewilmington.bakery.services.BakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BakerController {

    private BakerService service;

    @Autowired
    public BakerController(BakerService service) {
        this.service = service;
    }

    @GetMapping("/bakers/")
    public ResponseEntity<Iterable<Baker>> index() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }

    @GetMapping("/bakers/{id}")
    public ResponseEntity<Baker> show(@PathVariable Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }

    @PostMapping("/bakers/")
    public ResponseEntity<Baker> create(@RequestBody Baker baker) {
        return new ResponseEntity<>(service.create(baker), HttpStatus.CREATED);
    }

    @PutMapping("/bakers/{id}")
    public ResponseEntity<Baker> update(@PathVariable Long id, @RequestBody Baker baker) {
        return new ResponseEntity<>(service.update(id, baker), HttpStatus.OK);
    }

    @DeleteMapping("/bakers/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
