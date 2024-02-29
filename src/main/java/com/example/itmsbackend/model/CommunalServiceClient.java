package com.example.itmsbackend.model;

import com.example.itmsbackend.dto.CommunalTransportDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class CommunalServiceClient {

    private String communalServiceUrl = "";

    private RestTemplate restTemplate = new RestTemplate();


    public CommunalTransportDto getRoute(Long id) {
        ResponseEntity<CommunalTransportDto> response = restTemplate.getForEntity(communalServiceUrl + "/communal-transport/" + id, CommunalTransportDto.class);
        return response.getBody();
    }

}
