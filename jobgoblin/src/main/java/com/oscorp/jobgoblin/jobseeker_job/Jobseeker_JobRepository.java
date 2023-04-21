package com.oscorp.jobgoblin.jobseeker_job;

import com.oscorp.jobgoblin.job.Job;
import com.oscorp.jobgoblin.job.JobService;
import com.oscorp.jobgoblin.jobseeker.JobSeekerService;
import com.oscorp.jobgoblin.recruiter.Recruiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class Jobseeker_JobRepository {
    @Autowired
    NamedParameterJdbcTemplate template;

    List<Jobseeker_Job> getByJobs(long jobsid) {
        String query = "select jobsid, jobid, rel from jobseeker_job where jobsid = " + jobsid;
        return template.query(query,
                (result, rowNum)
                        -> new Jobseeker_Job(result.getLong("jobsid"),
                        result.getLong("jobid"), result.getInt("rel")));
    }
    List<Jobseeker_Job> getByJob(long jobid) {
        String query = "select jobsid, jobid, rel from jobseeker where jobid = " + jobid;
        return template.query(query,
                (result, rowNum)
                        -> new Jobseeker_Job(result.getLong("jobsid"),
                        result.getLong("jobid"), result.getInt("rel")));
    }

    List<Job> getJobByJobsidandRel(long jobsid, long rel){
        String query = "select id, name, descr, companyID, date_Posted, salary_High, salary_Low from job where id in " +
                "(select jobid from jobseeker_job where jobsid=" + jobsid + " and rel=" + rel + ")";
        return template.query(query,
                (result, rowNum)
                        -> new Job(result.getLong("id"), result.getString("name"), result.getString("descr"), result.getLong("companyID"), result.getString("date_Posted"), result.getInt("salary_High"), result.getInt("salary_Low")));
    }

    int getRel(long jobsid, long jobid){
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue(
                "jobsid", jobid).addValue("jobid", jobid);
        String query = "select rel from jobseeker_job where jobsid=:jobsid and jobid=:jobid";
        return template.queryForObject(query, namedParameters,
                Integer.class);
    }

   /* List<Recruiter> getRecwoRel(long comid) {
        String query = "select * from recruiter where id not in " +
                "(select recid from recruiter_company where comid = " + comid + ")";
        return template.query(query,
                (result, rowNum)
                        -> new Recruiter(result.getLong("id"),
                        result.getString("name"), result.getString(
                        "email"),result.getString(
                        "description"),result.getString(
                        "start_date"),result.getDouble(
                        "rating")));
    }
*/
    public int savJobsjob(Jobseeker_Job jobsjob){
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("jobsid", jobsjob.getJobsid());
        paramMap.put("jobid", jobsjob.getJobid());
        paramMap.put("rel", jobsjob.getRel());
        String query = "INSERT INTO jobseeker_job(jobsid, jobid, rel) VALUES(:jobsid, :jobid, :rel)";
        return template.update(query, paramMap);
    }

    void updateJobsjob(Jobseeker_Job jobsjob){
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("jobsid", jobsjob.getJobsid());
        paramMap.put("jobid", jobsjob.getJobid());
        paramMap.put("rel", jobsjob.getRel());
        System.out.println(jobsjob.getJobsid() + " " + jobsjob.getJobid() + " " + jobsjob.getRel());
        String query = "update jobseeker_job set jobsid=:jobsid, jobid=:jobid, rel=:rel where jobsid=:jobsid and jobid=:jobid";
        template.update(query, paramMap);
    }
    void deleteJobsjob(long jobsid, long jobid){
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("jobsid", jobsid).addValue("jobid", jobid);
        String query = "delete from jobseeker_job where jobsid=:jobsid and jobid=:jobid";
        template.update(query, namedParameters);
    }

}
