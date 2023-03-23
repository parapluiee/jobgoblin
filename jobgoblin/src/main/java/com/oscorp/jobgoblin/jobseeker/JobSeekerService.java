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
    private JobSeekerRepository repo;

    public List<JobSeeker> getAllJobSeekers() {
        return repo.findAll();
    }

    public JobSeeker getJobSeeker(long jobseekerId) {
        return repo.getReferenceById(jobseekerId);
    }

    public void deleteJobSeeker(long jobseekerId) {
        repo.deleteById(jobseekerId);
    }

    void saveJobSeeker(JobSeeker jobseeker) {
        repo.save(jobseeker);
    }
}
