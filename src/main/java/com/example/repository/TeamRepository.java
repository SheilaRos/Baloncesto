package com.example.repository;

import com.example.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long>{
    //Buscar los equipos de una localidad determinada
    List<Team> findByLocalityIs(String locality);
}