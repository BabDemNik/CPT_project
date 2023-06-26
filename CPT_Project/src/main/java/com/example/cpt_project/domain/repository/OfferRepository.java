package com.example.cpt_project.domain.repository;

import com.example.cpt_project.domain.models.Offers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface OfferRepository extends JpaRepository<Offers, Long> {

    Offers findOffersById(Long id);

    @Transactional
    @Query(nativeQuery = true, value = "SELECT * FROM offers o where o.id_user = :user_id")
    List<Offers> findOffersByIdUser(Long user_id);


}
