package com.example.itmsbackend.service;

import com.example.itmsbackend.dto.CommunalTransportDto;
import com.example.itmsbackend.model.CombinedRoute;
import com.example.itmsbackend.model.CommunalServiceClient;
import com.example.itmsbackend.model.FavoriteRoute;
import com.example.itmsbackend.model.Route;
import com.example.itmsbackend.repository.CombinedRouteRepository;
import com.example.itmsbackend.repository.FavoriteRouteRepository;
import com.example.itmsbackend.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private FavoriteRouteRepository favoriteRouteRepository;

    @Autowired
    private CommunalServiceClient communalServiceClient;

    @Autowired
    private CombinedRouteRepository combinedRouteRepository;




    public List<Route> getAll() {
        return routeRepository.findAll();
    }

    public List<Route> getRouteByStartAndEnd(String start, String end) {
        return routeRepository.findRouteByStartAndEnd(start, end);
    }

    public List<Route> getCarRoutes(String transportType , String start, String end) {
        return routeRepository.findRoutesByTransportTypeAndStartAndEnd(transportType, start, end);
    }


    public void create(Route route) {
        routeRepository.save(route);
    }


    public FavoriteRoute createFavoriteRoute(Long id, FavoriteRoute favoriteRoute) {
        Route route = routeRepository.findById(id).orElseThrow();
        favoriteRoute.setRoute(route);

        return favoriteRouteRepository.save(favoriteRoute);

    }

    public List<FavoriteRoute> getFavoriteRouteByIDAndType(Long id, String transportType) {
        return favoriteRouteRepository.findFavoriteRouteByIdAndTransportType(id, transportType);
    }

    public List<FavoriteRoute> getFavoriteRoutes(Long id) {
        return routeRepository.findById(id).orElseThrow().getFavoriteRoutes();
    }

    public void delete(Long id) {
        favoriteRouteRepository.deleteById(id);
    }


    public CombinedRoute createCombinedRoute(Long communalTransportDtoId, Long routeId) {
        CommunalTransportDto communalTransportDto = communalServiceClient.getRoute(communalTransportDtoId);
        Route route = routeRepository.findById(routeId).orElseThrow(() -> new RuntimeException("CommunalTransport not found with id " + routeId));

        CombinedRoute combinedRoute = new CombinedRoute();
        combinedRoute.setStartRoute(route.getStart());
        combinedRoute.setEndCommunalTransport(communalTransportDto.getToPlace());
        return combinedRouteRepository.save(combinedRoute);
    }

    public List<CombinedRoute> getAllCombinedRoutes() {
        return combinedRouteRepository.findAll();

    }


}
