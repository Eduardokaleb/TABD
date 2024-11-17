package com.example.show.model;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Encrypted;
@Setter
@Getter
@Encrypted
@Entity

public class Show {

        @Id
        private int showId;
        private String location;
        private String date;
        private int availableTickets;


        public Show() {}


        public Show(int showId, String location, String date, int availableTickets) {
            this.showId = showId;
            this.location = location;
            this.date = date;
            this.availableTickets = availableTickets;
        }


}


