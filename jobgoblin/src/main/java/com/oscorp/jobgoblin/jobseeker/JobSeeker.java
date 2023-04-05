package com.oscorp.jobgoblin.jobseeker;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 *
 * @author Maximilian
 */

@AllArgsConstructor
@Entity
@Table(name = "templates/jobseeker")
@NoArgsConstructor
@Getter
@Setter
public class JobSeeker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String username;
    private String email;
    private double prevsalary;

    public JobSeeker(String name, String username, String email, double prevsalary) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.prevsalary = prevsalary;
    }
}
