package com.example.service;

import com.example.domain.Player;
import com.example.domain.Team;
import com.example.repository.PlayerRepository;
import com.example.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * Created by dam on 20/10/16.
 */
@Service
public class PlayerService {
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PlayerRepository playerRepository;
    public void testPlayer(){
        Player player1 = new Player("", LocalDate.of(2015, 12, 31), 0, 0, 0, "");
        Player player2 = new Player("", LocalDate.of(2015, 12, 31), 0, 0, 0, "");
        Player player3 = new Player("", LocalDate.of(2015, 12, 31), 0, 0, 0, "");
        player1.setTeam(teamRepository.findOne(1L));
        playerRepository.save(player1);
        player2.setTeam(teamRepository.findOne(1L));
        playerRepository.save(player2);
        player3.setTeam(teamRepository.findOne(1L));
        playerRepository.save(player3);

        Player player4 = new Player("", LocalDate.of(2015, 12, 31), 0, 0, 0, "");
        Player player5 = new Player("", LocalDate.of(2015, 12, 31), 0, 0, 0, "");
        Player player6 = new Player("", LocalDate.of(2015, 12, 31), 0, 0, 0, "");
        Team poticaros = teamRepository.findOne(2L);
        player4.setTeam(poticaros);
        playerRepository.save(player4);
        player5.setTeam(poticaros);
        playerRepository.save(player5);
        player6.setTeam(poticaros);
        playerRepository.save(player6);

        Player player7 = new Player("", LocalDate.of(2015, 12, 31), 0, 0, 0, "");
        Player player8 = new Player("", LocalDate.of(2015, 12, 31), 0, 0, 0, "");
        Player player9 = new Player("", LocalDate.of(2015, 12, 31), 0, 0, 0, "");
        Team rompe = teamRepository.findOne(3L);
        player7.setTeam(rompe);
        playerRepository.save(player7);
        player8.setTeam(rompe);
        playerRepository.save(player8);
        player9.setTeam(rompe);
        playerRepository.save(player9);
    }
}
