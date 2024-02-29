package com.example.itmsbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "combined_routes")
public class CombinedRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String startRoute;
    private String endCommunalTransport;

}
