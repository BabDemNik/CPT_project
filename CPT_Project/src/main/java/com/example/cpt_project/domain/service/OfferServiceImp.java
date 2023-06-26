package com.example.cpt_project.domain.service;

import com.example.cpt_project.domain.models.Offers;
import com.example.cpt_project.domain.repository.OfferRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.List;

@Service
public class OfferServiceImp implements OfferService{

    private final OfferRepository offerRepository;

    public OfferServiceImp(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public void crete(Offers offers) {
        offerRepository.save(offers);
    }

    @Override
    public List<Offers> readAll() {
        return offerRepository.findAll();
    }

    public Offers readSingle(Long id){
        return offerRepository.findOffersById(id);
    }

    public List<Offers> readOfferByIdUser(Long id){
        return offerRepository.findOffersByIdUser(id);
    }



    @Override
    public boolean update(Offers offer, Long id) {
        if (offerRepository.existsById(id)){
            offer.setId(id);
            offerRepository.save(offer);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (offerRepository.existsById(id)){
            offerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public void downloadFile(String urlFile) throws IOException {
        URL url = new URL(urlFile);
        URLConnection connection = url.openConnection();

        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(1);
        outputStream.flush();

        InputStream inputStream = connection.getInputStream();
        Files.copy(inputStream, new File("C:/test_file.txt").toPath());
    }
}
