package com.oscorp.jobgoblin.jobseeker;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Maximilian
 */

@Service
public class JobSeekerService {
    
    @Autowired
    protected JobSeekerRepository repo;

    public List<JobSeeker> getAllJobSeekers() {
        return repo.findAll();
    }
    public Object getJobSeeker(long jobseekerId){
        return repo.getJobSeekerById(jobseekerId);
    }
    public void deleteJobSeeker(long jobseekerId) {
        repo.deleteJobSeekerById(jobseekerId);
    }

    public void saveJobSeeker(JobSeeker jobseeker) {
        repo.saveJobSeeker(jobseeker);
    }
    public void updateJobSeeker(JobSeeker jobseeker){
        repo.updateJobSeeker(jobseeker);
    }
}
