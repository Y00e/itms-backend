package com.example.itmsbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String transportType;
    private String start;
    private String end;
    private int distance;
    private String weather;
    private int time;


    @OneToMany(mappedBy = "route")
    private List<FavoriteRoute> favoriteRoutes;


}
