package com.oscorp.jobgoblin.jobseeker_job;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "jobseeker_job")
@NoArgsConstructor
@Getter
@Setter
public class Jobseeker_Job {
    @Id
    private Long jobsid;
    @Id
    private Long jobid;
    int rel;
    public Jobseeker_Job(long jobsid, long jobid, int rel){
        this.jobsid = jobsid;
        this.jobid = jobid;
        this.rel = rel;
    }

    public long getJobsid(){
        return jobsid;
    }

    public long getJobid(){
        return jobid;
    }

    public int getRel(){return rel;}
}
