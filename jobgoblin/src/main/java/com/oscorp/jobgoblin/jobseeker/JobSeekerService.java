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

    public JobSeeker getJobSeeker(long jseekerId) {
        return repo.getReferenceById(jseekerId);
    }

    public void deleteJobSeeker(long jseekerId) {
        repo.deleteById(jseekerId);
    }

    void saveJobSeeker(JobSeeker jseeker) {
        repo.save(jseeker);
    }
}
