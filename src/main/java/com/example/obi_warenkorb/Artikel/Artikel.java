package com.example.obi_warenkorb.Artikel;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table
public class Artikel {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private BigDecimal cost;
    private int mindestanzahl;
    private int bestand;

    public Artikel() {
    }

    public Artikel(Long id) {
        this.id = id;
    }

    public void substractBestand(int amount){
        this.bestand -= amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal value) {
        this.cost = value;
    }

    public int getMindestanzahl() {
        return mindestanzahl;
    }

    public void setMindestanzahl(int mindestanzahl) {
        this.mindestanzahl = mindestanzahl;
    }

    public int getBestand() {
        return bestand;
    }

    public void setBestand(int bestand) {
        this.bestand = bestand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artikel artikel = (Artikel) o;
        return id.equals(artikel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
