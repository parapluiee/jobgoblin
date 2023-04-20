package com.oscorp.jobgoblin.resume;

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
@Table(name = "resume")
@NoArgsConstructor
@Getter
@Setter
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long resumeId;
    private long jobseekerId;
    private String name;
    private String city;
    private String description;
    private String experience;
    private String previousJobs;
    private String email;

    public Resume(long jobseekid,String name, String city, String desc, String exper, String prev_jobs, String email) {
        this.jobseekerId = jobseekid;
        this.name = name;
        this.city = city;
        this.description = desc;
        this.experience = exper;
        this.previousJobs = prev_jobs;
        this.email = email;
    }
}
