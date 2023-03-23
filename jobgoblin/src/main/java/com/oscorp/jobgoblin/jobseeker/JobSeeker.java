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
@Table(name = "jobseeker")
@NoArgsConstructor
@Getter
@Setter
public class JobSeeker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String userName;
    private String email;
    private double prevSalary;

    public JobSeeker(String name, String userName, String email, double prevSalary) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.prevSalary = prevSalary;
    }
}
