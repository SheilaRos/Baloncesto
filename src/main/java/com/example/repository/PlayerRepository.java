package com.example.repository;

import com.example.domain.Player;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long>{
    //Buscar jugador por nombre sin necesitar escribirlo completamente
    List<Player> findByNameContaining(String name);
    //Buscar jugador que haya hecho mayor o igual a un número de canastas
    List<Player>findByBasketsGreaterThanEqual(Integer baskets);
    //Buscar jugadores que hayan echo asistencias dentro de un rango
    List<Player>findByAssistsBetween(Integer minAssists, Integer maxAssists);
    //Buscar jugadores con una posición especifica
    List<Player>findByCampPositionIs(String campPosition);
    //Buscar jugadores que hayan nacido en una fecha anterior a la especificada
    List<Player>findByBirthdayBefore(LocalDate birthday);
    //media de canastas, asistencias y rebotes agrupados por posición en el campo
    @Query("SELECT player.campPosition, AVG(player.baskets), AVG(player.assists), AVG(player.rebounds) "
            + "FROM Player player "
            +"GROUP BY player.campPosition")
    List<Object[]>AVGBasketsANDAssistsANDRebounds();
    //media, min y max de canastas, asistencias y rebotes agrupados por posición en el campo
    @Query("SELECT player.campPosition, AVG(player.baskets), max(player.baskets), min(player.baskets), AVG(player.assists), max(player.assists), min(player.assists), " +
            "AVG(player.rebounds), max(player.rebounds), min(player.rebounds) "
            + "FROM Player player "
            +"GROUP BY player.campPosition")
    List<Object[]>AVGANDMaxANDMinTOBasketsANDAssistsANDRebounds();
    //Busca la lista de jugadores de un equipo
    List<Player>findByTeamNameIs(String name);
    //Buscar el jugador de un equipo y posición determinado
    List<Player>findByTeamNameIsAndCampPositionIs(String name, String campPosition);
    //Mostrar el jugador con más canastas de un equipo determinado
    //usamos el pageable para que nos muestre un intervalo de jugadores que indicaremos al llamar la consulta, será (0, 1) porque solo queremos el primer jugador
    @Query("SELECT player " + " FROM Player player " + "WHERE player.team.name = :teamName"+" ORDER BY player.baskets desc")
    List<Player>namePlayer(@Param("teamName") String teamName, Pageable pageable);
}

