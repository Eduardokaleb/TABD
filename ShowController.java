package com.example.show.controller;

import com.example.show.model.Show;
import com.example.show.repository.ShowRepository;
import com.example.show.controller.ShowController;
import com.example.show.service.ShowService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Encrypted;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/shows")
public class ShowController {

    @Autowired
    private ShowRepository showRepository;



    @GetMapping
    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    @PostMapping
    public Show createShow(@RequestBody Show show) {
        return showRepository.save(show);
    }


    @GetMapping("/{id}")
    public Show getShowById(@PathVariable int id) {
        return showRepository.findById(id).orElse(null);
    }


    @PutMapping("/{id}")
    public Show updateShow(@PathVariable int id, @RequestBody Show updatedShow) {
        return showRepository.findById(id).map(show -> {
            show.setLocation(updatedShow.getLocation());
            show.setDate(updatedShow.getDate());
            show.setAvailableTickets(updatedShow.getAvailableTickets());
            return showRepository.save(show);
        }).orElse(null);
    }


    @DeleteMapping("/{id}")
    public void deleteShow(@PathVariable int id) {
        showRepository.deleteById(id);
    }
}
