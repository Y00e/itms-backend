package com.example.itmsbackend.repository;

import com.example.itmsbackend.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {


    List<Route> findRouteByStartAndEnd(String start, String end);

    List<Route> findRoutesByTransportTypeAndStartAndEnd(String transportType, String start, String end);


}
