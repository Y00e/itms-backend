package com.example.itmsbackend.repository;

import com.example.itmsbackend.model.FavoriteRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRouteRepository extends JpaRepository<FavoriteRoute, Long> {

    List<FavoriteRoute> findFavoriteRouteByIdAndTransportType(Long id, String transportType);
}
