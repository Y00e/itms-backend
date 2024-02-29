package com.example.itmsbackend.model;

import com.example.itmsbackend.dto.CommunalTransportDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CommunalServiceClient {

    private String communalServiceUrl = "https://transport-service.azurewebsites.net/api";

    private RestTemplate restTemplate = new RestTemplate();


    public CommunalTransportDto getRoute(Long id) {
        ResponseEntity<CommunalTransportDto> response = restTemplate.getForEntity(communalServiceUrl + "/communal-transport" + id, CommunalTransportDto.class);
        return response.getBody();
    }

}
