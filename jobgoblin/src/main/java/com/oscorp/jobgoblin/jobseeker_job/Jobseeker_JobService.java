package com.oscorp.jobgoblin.jobseeker_job;

import com.oscorp.jobgoblin.job.Job;
import com.oscorp.jobgoblin.recruiter.Recruiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Jobseeker_JobService {
    @Autowired
    Jobseeker_JobRepository repo;

    List<Jobseeker_Job> getByJobsid(long jobsid){
        return repo.getByJobs(jobsid);
    }

    List<Jobseeker_Job> getByJobid(long jobid) {
        return repo.getByJob(jobid);
    }

    int getRel(long jobsid, long jobid){
        return repo.getRel(jobsid, jobid);
    }
    /*List<Recruiter> getRecwoRel(long ){
        return repo.getRecwoRel(comid);
    }
*/
    int saveJobsjob(Jobseeker_Job jobsjob){
        return repo.savJobsjob(jobsjob);
    }
    void updateJobsjob(Jobseeker_Job jobsjob){
        repo.updateJobsjob(jobsjob);
    }
    void delreccom(long jobsid, long jobid){repo.deleteJobsjob(jobsid, jobid);}

    List<Job> getJobByJobsidAndRel(long jobsid, int rel){
        System.out.println(repo.getJobByJobsidandRel(jobsid, rel).get(0));
        return repo.getJobByJobsidandRel(jobsid, rel);
    }
}