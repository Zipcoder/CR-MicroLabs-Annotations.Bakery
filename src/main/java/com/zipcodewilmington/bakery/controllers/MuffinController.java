package com.zipcodewilmington.bakery.controllers;

import com.zipcodewilmington.bakery.models.Muffin;
import com.zipcodewilmington.bakery.services.MuffinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MuffinController {

    private MuffinService service;

    @Autowired
    public MuffinController(MuffinService service) {
        this.service = service;
    }

    @GetMapping(value = "/muffins")
    public ResponseEntity<Iterable<Muffin>> index() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }

    @GetMapping(value = "/muffins/{id}")
    public ResponseEntity<Muffin> show(@PathVariable Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }

    @PostMapping(value = "/muffins/")
    public ResponseEntity<Muffin> create(@RequestBody Muffin muffin) {
        return new ResponseEntity<>(service.create(muffin), HttpStatus.CREATED);
    }

    @PutMapping(value = "/muffins/{id}")
    public ResponseEntity<Muffin> update(@PathVariable Long id, @RequestBody Muffin muffin) {
        return new ResponseEntity<>(service.update(id, muffin), HttpStatus.OK);
    }

    @DeleteMapping(value = "/muffins/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
