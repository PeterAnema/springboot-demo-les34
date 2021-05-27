package com.example.demo.controller;

import com.example.demo.model.Persoon;
import com.example.demo.service.PersoonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/personen")
public class PersoonController {

    @Autowired
    private PersoonService persoonService;

    @GetMapping("")
    public ResponseEntity<Object> getPersonen() {
        return ResponseEntity.ok(persoonService.getPersonen());
    }

    @PostMapping("")
    public ResponseEntity<Object> addPersoon(@RequestBody Persoon persoon) {
        persoonService.addPersoon(persoon);
        return ResponseEntity.ok("Added");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPersoon(@PathVariable("id") long id) {
        Persoon persoon = persoonService.getPersoon(id);
        return ResponseEntity.ok(persoon);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePersoon(@PathVariable("id") long id, @RequestBody Persoon nieuwPersoon) {
        persoonService.updatePersoon(id, nieuwPersoon);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removePersoon(@PathVariable("id") long id) {
        persoonService.removePersoon(id);
        return ResponseEntity.noContent().build();
    }

}
