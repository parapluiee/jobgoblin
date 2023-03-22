package com.oscorp.jobgoblin.recruiter;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "recruiter")
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



    public Recruiter(String name, String email, String description, String startDate, double rating) {
        this.name=name;
        this.email=email;
        this.description=description;
        this.startDate=startDate;
        this.rating=rating;
    }


}
