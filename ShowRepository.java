package com.example.show.repository;
import com.example.show.model.Show;
import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Encrypted;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends MongoRepository<Show, Integer> {

    List<Show> findByLocation(String location);


    List<Show> findByDate(String date);


    List<Show> findByAvailableTicketsGreaterThan(int minTickets);


    List<Show> findByLocationAndDate(String location, String date);


    List<Show> findByOrderByAvailableTicketsDesc();

}