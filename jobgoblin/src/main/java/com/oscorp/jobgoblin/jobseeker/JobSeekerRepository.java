package com.oscorp.jobgoblin.jobseeker;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Maximilian
 */
public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long> {
    
}
