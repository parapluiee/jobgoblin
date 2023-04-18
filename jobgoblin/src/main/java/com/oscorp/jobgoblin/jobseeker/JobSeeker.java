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
    private long jobseekerId;
    private String name;
    private String username;
    private String password;
    private String email;
    private String dob;
    private String description;
    private double prevSalary;

    public JobSeeker(String name, String username,String password,String email,String dob,String desc,double prevsalary) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.dob = dob;
        this.description = desc;
        this.prevSalary = prevsalary;
    }
}
