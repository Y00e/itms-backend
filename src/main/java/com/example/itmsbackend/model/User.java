package com.example.itmsbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Route> routes;

    @OneToMany(mappedBy = "user")
    private List<FavoriteRoute> favoriteRoutes;


}
