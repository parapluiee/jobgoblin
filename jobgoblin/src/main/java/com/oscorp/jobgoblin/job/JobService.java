package com.oscorp.jobgoblin.job;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class JobService {
    @Autowired
    JobRepository repo;

    List<Job> getAllJobs() {return repo.findAll();}

    void saveJob(Job job) {repo.saveJob(job);}

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
