package com.example.show.service;

import com.example.show.model.Show;
import com.example.show.repository.ShowRepository;
import com.example.show.controller.ShowController;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Encrypted;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;


    public Show saveShow(Show show) {

        if (show.getAvailableTickets() < 0) {
            throw new IllegalArgumentException("O número de ingressos disponíveis não pode ser negativo.");
        }
        return showRepository.save(show);
    }


    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    public Optional<Show> getShowById(int id) {
        return showRepository.findById(id);
    }


    public Show updateShow(int id, Show updatedShow) {
        Optional<Show> existingShow = showRepository.findById(id);

        if (existingShow.isPresent()) {
            Show show = existingShow.get();
            show.setLocation(updatedShow.getLocation());
            show.setDate(updatedShow.getDate());
            show.setAvailableTickets(updatedShow.getAvailableTickets());
            return showRepository.save(show);
        } else {
            throw new IllegalArgumentException("Show com ID " + id + " não encontrado.");
        }
    }


    public void deleteShow(int id) {
        if (!showRepository.existsById(id)) {
            throw new IllegalArgumentException("Show com ID " + id + " não existe.");
        }
        showRepository.deleteById(id);
    }


}
