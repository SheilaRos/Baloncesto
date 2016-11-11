package com.example.domain;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String locality;
    private LocalDate creationDate;
    //constructor vacio
    public Team() {
    }
    //constructor
    public Team(String name, String locality, LocalDate creationDate) {
        this.name = name;
        this.locality = locality;
        this.creationDate = creationDate;
    }
    //Getter y setter
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

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    //CompareTo --> sirve para ordenar los objetos de una manera natural, se utiliza sobretodo en Treemap
    //HashCode -> sirve para utilizar metodos de hash, convierte el objeto en un entero para así útilizarlo de una manera más rápida
    //Equals -> sirve para saber si dos objetos son iguales

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (id != team.id) return false;
        if (name != null ? !name.equals(team.name) : team.name != null) return false;
        if (locality != null ? !locality.equals(team.locality) : team.locality != null) return false;
        return creationDate != null ? creationDate.equals(team.creationDate) : team.creationDate == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (locality != null ? locality.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Team:" +
                "id= " + id + '\n'+
                "name='" + name + '\'' +'\n'+
                "locality='" + locality + '\'' +'\n'+
                "creationDate=" + creationDate ;
    }

}