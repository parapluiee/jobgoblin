package com.oscorp.jobgoblin.company;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "company")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String descr;
    private String email;
    private String foundingDate;
    private String startDate;
    private String webLink;
    private double rating;
    private int numRatings;

    Company(String name,
            String descr,
            String email,
            String foundingDate,
            String startDate,
            String webLink,
            double rating,
            int numRatings){

        this.name = name;
        this.descr = descr;
        this.email = email;
        this.foundingDate = foundingDate;
        this.startDate = startDate;
        this.webLink = webLink;
        this.rating = rating;
        this.numRatings = numRatings;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescr() {
        return descr;
    }

    public String getEmail(){ return email;}
    public String getFoundingDate(){
        return foundingDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getWebLink() {
        return webLink;
    }

    public double getRating() {
        return rating;
    }

    public int getNumRatings() {
        return numRatings;
    }
}
