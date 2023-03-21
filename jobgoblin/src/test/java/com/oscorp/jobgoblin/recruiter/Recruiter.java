package com.oscorp.jobgoblin.recruiter;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "spell")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Recruiter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String startDate;
    private String description;
    private String name;
    private double rating;



    public Recruiter(String email, String startDate, String description, String name, double rating) {
        this.email=email;
        this.startDate=startDate;
        this.description=description;
        this.name=name;
        this.rating=rating;
    }


}
