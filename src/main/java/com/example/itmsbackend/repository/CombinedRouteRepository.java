package com.example.itmsbackend.repository;

import com.example.itmsbackend.model.CombinedRoute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CombinedRouteRepository extends JpaRepository<CombinedRoute, Long > {

    List <CombinedRoute> findCombinedRouteById(Long id);
}
