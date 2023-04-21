package com.oscorp.jobgoblin.jobseeker;

import com.oscorp.jobgoblin.job.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Maximilian
 */
@Repository
public class JobSeekerRepository {

    @Autowired
    NamedParameterJdbcTemplate template;

    List<JobSeeker> findAll() {
        String query = "select jobseeker_id, name,username,password,email,dob,description,prev_salary from jobseeker";
        return template.query(query,
                (result, rowNum)
                -> new JobSeeker(result.getLong("jobseeker_id"),
                        result.getString("name"), result.getString(
                        "username"), result.getString(
                                "password"), result.getString(
                                "email"), result.getString("dob"),
                        result.getString("description"), result.getDouble(
                        "prev_salary")));
    }
    
    List<Job> findAllJobs() {
        String query = "select id, name, descr, companyID, date_Posted, salary_High, salary_Low from job";
        return template.query(query,
                (result, rowNum)
                -> new Job(result.getLong("id"), result.getString("name"), result.getString("descr"), result.getLong("companyID"), result.getString("date_Posted"), result.getInt("salary_High"), result.getInt("salary_Low")));

    }
    public JobSeeker getJobSeekerById(long id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue(
                "jobseekerId", id);
        String query = "select * from jobseeker where jobseeker_id=:jobseekerId ";
        return template.queryForObject(query, namedParameters,
                BeanPropertyRowMapper.newInstance(JobSeeker.class));
    }

    public int saveJobSeeker(JobSeeker jobseeker) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", jobseeker.getName());
        paramMap.put("username", jobseeker.getUsername());
        paramMap.put("password", jobseeker.getPassword());
        paramMap.put("email", jobseeker.getEmail());
        paramMap.put("dob", jobseeker.getDob());
        paramMap.put("description", jobseeker.getDescription());
        paramMap.put("prevSalary", jobseeker.getPrevSalary());
        String query = "INSERT INTO jobseeker(name,username,password,email,dob,description,prev_salary) "
                + "VALUES(:name, :username, :password, :email, :dob, :description, :prevSalary)";
        return template.update(query, paramMap);
    }

    void deleteJobSeekerById(long id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue(
                "jobseekerId", id);
        String query = "delete from jobSeeker where jobseeker_id=:jobseekerId";
        template.update(query, namedParameters);
    }

    void updateJobSeeker(JobSeeker jobseeker) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("jobseekerId", jobseeker.getJobseekerId());
        paramMap.put("name", jobseeker.getName());
        paramMap.put("username", jobseeker.getUsername());
        paramMap.put("password", jobseeker.getPassword());
        paramMap.put("email", jobseeker.getEmail());
        paramMap.put("dob", jobseeker.getDob());
        paramMap.put("description", jobseeker.getDescription());
        paramMap.put("prevSalary", jobseeker.getPrevSalary());
        String query = "update jobseeker set name=:name,username=:username,password=:password,email=:email,dob=:dob,description=:description,prev_salary=:prevSalary where jobseeker_id=:jobseekerId";
        template.update(query, paramMap);
    }
}
