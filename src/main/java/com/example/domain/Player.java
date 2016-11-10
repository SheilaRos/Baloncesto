package com.example.domain;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
    public class Player {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        private String name;
        private LocalDate birthday;
        private Integer baskets;
        private Integer assists;
        private Integer rebounds;
        private String campPosition;
        @ManyToOne
        private Team team;


    public Player() {
    }

    public Player(String name, LocalDate birthday, Integer baskets, Integer assists, Integer rebounds, String campPosition) {
        this.name = name;
        this.birthday = birthday;
        this.baskets = baskets;
        this.assists = assists;
        this.rebounds = rebounds;
        this.campPosition = campPosition;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Integer getBaskets() {
        return baskets;
    }

    public void setBaskets(Integer baskets) {
        this.baskets = baskets;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getRebounds() {
        return rebounds;
    }

    public void setRebounds(Integer rebounds) {
        this.rebounds = rebounds;
    }

    public String getCampPosition() {
        return campPosition;
    }

    public void setCampPosition(String campPosition) {
        this.campPosition = campPosition;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    //CompareTo --> sirve para ordenar los objetos de una manera natural, se utiliza sobretodo en Treemap
    //HashCode -> sirve para utilizar metodos de hash, convierte el objeto en un entero para así útilizarlo de una manera más rápida
    //Equals -> sirve para saber si dos objetos son iguales


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (id != player.id) return false;
        if (name != null ? !name.equals(player.name) : player.name != null) return false;
        if (birthday != null ? !birthday.equals(player.birthday) : player.birthday != null) return false;
        if (baskets != null ? !baskets.equals(player.baskets) : player.baskets != null) return false;
        if (assists != null ? !assists.equals(player.assists) : player.assists != null) return false;
        if (rebounds != null ? !rebounds.equals(player.rebounds) : player.rebounds != null) return false;
        if (campPosition != null ? !campPosition.equals(player.campPosition) : player.campPosition != null)
            return false;
        return team != null ? team.equals(player.team) : player.team == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (baskets != null ? baskets.hashCode() : 0);
        result = 31 * result + (assists != null ? assists.hashCode() : 0);
        result = 31 * result + (rebounds != null ? rebounds.hashCode() : 0);
        result = 31 * result + (campPosition != null ? campPosition.hashCode() : 0);
        result = 31 * result + (team != null ? team.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Player:" +'\n'+
                "id=" + id + '\n'+
                "name='" + name + '\'' +'\n'+
                "birthday=" + birthday +'\n'+
                "baskets=" + baskets +'\n'+
                "assists=" + assists +'\n'+
                "rebounds=" + rebounds +'\n'+
                "campPosition='" + campPosition + '\'' + '\n'+
                "[" + team +"]"+'\n';
    }
}
