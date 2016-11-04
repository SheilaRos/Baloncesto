package com.example.service;

import com.example.domain.Team;
import com.example.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * Created by dam on 20/10/16.
 */
@Service
public class TeamService {
    @Autowired
            private TeamRepository teamRepository;
    public void testTeam(){
        Team team1=new Team();
        team1.setName("Los Tangencios");
        team1.setLocality("Guasa");
        team1.setCreationDate(LocalDate.of(2015, 12, 31));

        Team team2=new Team();
        team2.setName("Los Poticaros");
        team2.setLocality("Novés");
        team2.setCreationDate(LocalDate.of(2015, 11, 03));

        Team team3=new Team();
        team3.setName("Las Rompe Lentejuelas");
        team3.setLocality("Moratones");
        team3.setCreationDate(LocalDate.of(2015, 05, 21));


    }
}
