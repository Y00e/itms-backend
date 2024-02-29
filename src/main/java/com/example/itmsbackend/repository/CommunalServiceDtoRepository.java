package com.example.itmsbackend.repository;

import com.example.itmsbackend.dto.CommunalTransportDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunalServiceDtoRepository extends JpaRepository<CommunalTransportDto, Long> {

}
