package com.example.cpt_project.domain.controllers;

import com.example.cpt_project.domain.models.Offers;
import com.example.cpt_project.domain.repository.OfferRepository;
import com.example.cpt_project.domain.service.OfferService;
import com.example.cpt_project.domain.service.OfferServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;
@RestController
public class OffersControllers {

    private final OfferRepository Repository;

    private final OfferServiceImp service;

    @Autowired
    public OffersControllers(OfferRepository repository, OfferServiceImp service) {
        Repository = repository;
        this.service = service;
    }

    @PostMapping(value = "/offers/{url}")
    public ResponseEntity<?> createOffer(@PathVariable(name = "url") String url ,@RequestBody Offers offer) throws IOException {
        Date getDate = new Date();
        offer.setDate(getDate);
        offer.setFile(url);
        service.downloadFile(url);
        service.crete(offer);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/offers")
    public ResponseEntity<List<Offers>> readAll(){
        final List<Offers> offers = service.readAll();

        return offers != null && !offers.isEmpty()
                ? new ResponseEntity<>(offers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/offers/{id}")
    public ResponseEntity<Offers> read(@PathVariable(name = "id") Long id){
        final Offers offer = service.readSingle(id);

        return offer != null
                ? new ResponseEntity<>(offer, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/offers/user/{user_id}")
    public ResponseEntity<List<Offers>> readOffersByUser(@PathVariable(name = "user_id") Long id){
        final List<Offers> offers = Repository.findOffersByIdUser(id);

        return offers != null && !offers.isEmpty()
                ? new ResponseEntity<>(offers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/offers/{id}")
    public ResponseEntity<?> updateOffer(@PathVariable(name = "id") Long id, @RequestBody Offers offers){
        final boolean update = service.update(offers, id);

        return update
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }


}
