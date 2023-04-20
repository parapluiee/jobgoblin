package com.oscorp.jobgoblin.job;
import java.util.List;

import com.oscorp.jobgoblin.recruiter.Recruiter;
import com.oscorp.jobgoblin.recruiter.RecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class JobService {
    @Autowired
    JobRepository repo;
    @Autowired
    RecruiterRepository repo2;

    public List<Job> getAllJobs() {return repo.findAll();}
    List<Job> getJobsByComp(long comid){ return repo.findByComp(comid);}
    void saveJob(Job job) {repo.saveJob(job);}

    Recruiter getRecById(long id){return repo2.getRecruiterById(id);}

    Object getJob(long id){
        return repo.getJobByID(id);
    }

    void deleteJob(long id){
        repo.deleteJobByID(id);
    }
    void updateJob(Job job){
        repo.updateJob(job);
    }

}
