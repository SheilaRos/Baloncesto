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
        private Team owner;


    public Player() {
    }

    public Player(String name, LocalDate birthday, Integer baskets, Integer assists, Integer rebounds, String campPosition, Team owner) {
        this.name = name;
        this.birthday = birthday;
        this.baskets = baskets;
        this.assists = assists;
        this.rebounds = rebounds;
        this.campPosition = campPosition;
        this.owner = owner;
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

    public Team getOwner() {
        return owner;
    }

    public void setOwner(Team owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", baskets=" + baskets +
                ", assists=" + assists +
                ", rebounds=" + rebounds +
                ", campPosition='" + campPosition + '\'' +
                ", owner=" + owner +
                '}';
    }
}
