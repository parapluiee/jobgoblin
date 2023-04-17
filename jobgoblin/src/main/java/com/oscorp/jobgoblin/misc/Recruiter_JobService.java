package com.oscorp.jobgoblin.misc;

import com.oscorp.jobgoblin.recruiter.Recruiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Recruiter_JobService {
    @Autowired
    Recruiter_JobRepository repo;

    List<Recruiter_Job> getByRec(long recid){
        return repo.getByRec(recid);
    }

    List<Recruiter_Job> getByJob(long jobid) {
        return repo.getByJob(jobid);
    }

    int getRel(long jobid, long recid){
        return repo.getRel(jobid, recid);
    }
    List<Recruiter> getRecwoRel(long jobid){
        return repo.getRecwoRel(jobid);
    }
}
