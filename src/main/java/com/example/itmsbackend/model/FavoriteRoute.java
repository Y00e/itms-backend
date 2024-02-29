package com.example.itmsbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "favorite_routes")
public class FavoriteRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String transportType;


    @ManyToOne
    @JsonIgnore
    private Route route;

    @ManyToOne
    @JsonIgnore
    private User user;
}
