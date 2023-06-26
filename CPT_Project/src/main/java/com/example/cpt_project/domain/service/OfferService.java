package com.example.cpt_project.domain.service;

import com.example.cpt_project.domain.models.Offers;

import java.util.List;

public interface OfferService {

    //Создание нового предлоения (Offer)
    void crete(Offers offers);



    //Вывод всех предложений
    List<Offers> readAll();

    //Обнавление предложения
    boolean update(Offers offer, Long id);

    //Удаление предложения
    boolean delete(Long id);
}
