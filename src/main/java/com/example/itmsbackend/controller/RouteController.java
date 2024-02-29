package com.example.itmsbackend.controller;

import com.example.itmsbackend.model.FavoriteRoute;
import com.example.itmsbackend.model.Route;
import com.example.itmsbackend.model.User;
import com.example.itmsbackend.service.RouteService;
import com.example.itmsbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;


    @Autowired
    private UserService userService;


    // http://localhost:8080/api/v1/routes/createUser
    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userService.createUser(user);

        return ResponseEntity.status(201).body("Success");
    }


    // POST http://localhost:8080/api/v1/routes
    @PostMapping
    public ResponseEntity<String> createNewRoute(@RequestBody Route route) {
        routeService.create(route);

        return ResponseEntity.status(201).body("Success");
    }



    // PUT http://localhost:8080/api/v1/routes/create/favoriteRoute/{id}
    @PutMapping("/create/favoriteRoute/{id}")
    public ResponseEntity<FavoriteRoute> createFavoriteRoute(@PathVariable Long id, @RequestBody FavoriteRoute favoriteRoute) {
        FavoriteRoute createdFavoriteRoute = routeService.createFavoriteRoute(id, favoriteRoute);

        if (createdFavoriteRoute != null) {
            return ResponseEntity.status(201).body(createdFavoriteRoute);
        } else {
            return ResponseEntity.status(400).build();
        }
    }


    // http://localhost:8080/api/v1/routes
    @GetMapping
    public ResponseEntity<List<Route>> getAllRoutes(){
        List<Route> routes = routeService.getAll();

        return ResponseEntity.status(200).body(routes);
    }

    // http://localhost:8080/api/v1/routes/search/{start}/{end}
    @GetMapping("search/{start}/{end}")
    public ResponseEntity <List<Route>> getRouteByStartAndEnd(@PathVariable String start,@PathVariable String end) {
        List<Route> routes = routeService.getRouteByStartAndEnd(start, end);

        if (routes != null) {
            return ResponseEntity.status(200).body(routes);
        }
        return ResponseEntity.status(404).build();
    }


    // http://localhost:8080/api/v1/routes/search/car/{start}/{end}
    @GetMapping("search/{transportType}/{start}/{end}")
    public ResponseEntity<List<Route>> getCarRoutes(@PathVariable String transportType, @PathVariable String start, @PathVariable String end) {
        List<Route> routes = routeService.getCarRoutes(transportType, start, end);


        if (routes != null) {
            return ResponseEntity.status(200).body(routes);
        }
        return ResponseEntity.status(404).build();

    }

    // GET http://localhost:8080/api/v1/routes/{id}/{transportType}
    @GetMapping("/{id}/{transportType}")
    public ResponseEntity <List<FavoriteRoute>> getAllFavoriteRoutesByIdAndTyp(@PathVariable Long id, @PathVariable String transportType) {
        List<FavoriteRoute> favoriteRoutes = routeService.getFavoriteRouteByIDAndType(id, transportType);

        if (favoriteRoutes != null && !favoriteRoutes.isEmpty()) {
            return ResponseEntity.status(200).body(favoriteRoutes);
        } else {
            return ResponseEntity.status(204).build();
        }

    }


    // GET http://localhost:8080/api/v1/routes/favoriteRoute/{id}
    @GetMapping("/favoriteRoute/{id}")
    public ResponseEntity <List<FavoriteRoute>> getAllFavoriteRoutes(@PathVariable Long id) {
        List<FavoriteRoute> favoriteRoutes = routeService.getFavoriteRoutes(id);

        if (favoriteRoutes != null && !favoriteRoutes.isEmpty()) {
            return ResponseEntity.status(200).body(favoriteRoutes);
        } else {
            return ResponseEntity.status(204).build();
        }

    }


    // DELETE http://localhost:8080/api/v1/routes/delete/favoriteRoute/{id}
    @DeleteMapping("/delete/favoriteRoute/{id}")
    public ResponseEntity<Void> deleteFavoriteRote(@PathVariable Long id) {
        routeService.delete(id);

        return ResponseEntity.status(204).build();
    }






}
