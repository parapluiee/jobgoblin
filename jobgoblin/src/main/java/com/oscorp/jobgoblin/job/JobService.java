package com.oscorp.jobgoblin.job;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class JobService {
    @Autowired
    JobRepository repo;

    public List<Job> getAllJobs() {return repo.findAll();}
    List<Job> getJobsByComp(long comid){ return repo.findByComp(comid);}
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
