package com.example.itmsbackend.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommunalTransportDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fromPlace;
    private String toPlace;
    private String departureTime;
    private String arrivalTime;
    private Integer numberOfTransfers;
    private String travelTime;
    private String walkTime;
    private String delayReport;
    private String estimatedDelay;

}