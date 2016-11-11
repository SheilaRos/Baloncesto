package com.example.service;

import com.example.domain.Player;
import com.example.domain.Team;
import com.example.repository.PlayerRepository;
import com.example.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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
        Player player1 = new Player("Leopoldo", LocalDate.of(1992, 12, 05), 8, 5, 2, "alero");
        Player player2 = new Player("Basiliso", LocalDate.of(1991, 06, 19), 3, 1, 4, "base");
        Player player3 = new Player("Anselmo", LocalDate.of(1992, 01, 25), 8, 0, 6, "pivot");
        player1.setTeam(teamRepository.findOne(1L));
        playerRepository.save(player1);
        player2.setTeam(teamRepository.findOne(1L));
        playerRepository.save(player2);
        player3.setTeam(teamRepository.findOne(1L));
        playerRepository.save(player3);

        Player player4 = new Player("Eustaquio", LocalDate.of(1994, 01, 31), 5, 8, 2, "alero");
        Player player5 = new Player("Falopio", LocalDate.of(1993, 02, 13), 10, 6, 4, "pivot");
        Player player6 = new Player("Dionisio", LocalDate.of(1992, 06, 25), 8, 11, 3, "base");
        Team poticaros = teamRepository.findOne(2L);
        player4.setTeam(poticaros);
        playerRepository.save(player4);
        player5.setTeam(poticaros);
        playerRepository.save(player5);
        player6.setTeam(poticaros);
        playerRepository.save(player6);

        Player player7 = new Player("Amancia", LocalDate.of(1994, 05, 28), 10, 12, 19, "base");
        Player player8 = new Player("Roberta", LocalDate.of(1996, 10, 15), 5, 5, 5, "pivot");
        Player player9 = new Player("Rodolfa", LocalDate.of(1995, 11, 16), 2, 4, 8, "alero");
        Team rompe = teamRepository.findOne(3L);
        player7.setTeam(rompe);
        playerRepository.save(player7);
        player8.setTeam(rompe);
        playerRepository.save(player8);
        player9.setTeam(rompe);
        playerRepository.save(player9);

        System.out.println("The teams of Guasa is " +teamRepository.findByLocalityIs("Guasa"));
        System.out.println("The player with the name start in Ama... is " +playerRepository.findByNameContaining("Ama"));
        System.out.println("The players with 6 or more baskets are "+playerRepository.findByBasketsGreaterThanEqual(6));
        System.out.println("The players between 5 or 10 assistance are "+playerRepository.findByAssistsBetween(5, 10));
        System.out.println("The players with pivot role are "+playerRepository.findByCampPositionIs("pivot"));
        System.out.println("The players with her birthday are before 14-05-1993 are "+playerRepository.findByBirthdayBefore(LocalDate.of(1993, 05, 14)));

        System.out.println("The AVG from baskets, assists and rebounds group by role are ");
        AVGBasketsANDAssistsANDRebounds(playerRepository.AVGBasketsANDAssistsANDRebounds());
        System.out.println("The AVG, Max. and Min. from baskets, assists and rebounds group by role are ");
        AVGANDMaxANDMinTOBasketsANDAssistsANDRebounds(playerRepository.AVGANDMaxANDMinTOBasketsANDAssistsANDRebounds());
        System.out.println("The players in Las Rompe Lentejuelas team are "+playerRepository.findByTeamNameIs("Las Rompe Lentejuelas"));
        System.out.println("The player in Los Tangencios and alero role is "+playerRepository.findByTeamNameIsAndCampPositionIs("Los Tangencios", "alero"));
        System.out.println("The player that have the most baskets in Los Poticaros team is "+playerRepository.namePlayer("Los Poticaros", new PageRequest(0, 1)));
    }

    private void AVGBasketsANDAssistsANDRebounds(List<Object[]> statisticsList) {
        for ( Object[] statistic: statisticsList)
        {
            System.out.println("Camp Position: "+statistic[0]);
            System.out.println("Baskets AVG = "+statistic[1]);
            System.out.println("Assists AVG = "+statistic[2]);
            System.out.println("Rebounds AVG = "+statistic[3]+System.lineSeparator());
        }
    }

    private void AVGANDMaxANDMinTOBasketsANDAssistsANDRebounds(List<Object[]> statisticsList) {
        for ( Object[] statistic: statisticsList)
        {
            System.out.println("Camp Position: "+statistic[0]);
            System.out.println("Baskets AVG = "+statistic[1]);
            System.out.println("Assists AVG = "+statistic[2]);
            System.out.println("Rebounds AVG = "+statistic[3]);
            System.out.println("Baskets Max = "+statistic[4]);
            System.out.println("Assists Max = "+statistic[5]);
            System.out.println("Rebounds Max = "+statistic[6]);
            System.out.println("Baskets Min = "+statistic[7]);
            System.out.println("Assists Min = "+statistic[8]);
            System.out.println("Rebounds Min = "+statistic[9]+System.lineSeparator());
        }
    }

    private void namePlayer(List<Object[]> statisticsList) {
        for ( Object[] statistic: statisticsList)
        {

            System.out.println("Player name = "+statistic[0]+System.lineSeparator());
        }
    }
}
