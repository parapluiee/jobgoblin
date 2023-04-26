package com.oscorp.jobgoblin.resume;

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
public class ResumeRepository {

    @Autowired
    NamedParameterJdbcTemplate template;

    public List<Resume> findAll() {
        String query = "select jobseeker_id, name,username,password,email,dob,description,prev_salary from jobseeker";
        return template.query(query,
                (result, rowNum)
                -> new Resume(result.getLong("jobseeker_id"),
                        result.getString("name"),
                        result.getString("city"), result.getString(
                        "description"), result.getString(
                                "experience"), result.getString(
                                "previous_jobs"), result.getString("email")));
    }

    public Resume getResumeByJobSeekerId(long id) {
         SqlParameterSource namedParameters = new MapSqlParameterSource().addValue(
                "jobseekerId", id);
        String query = "select * from resume where jobseeker_id=:jobseekerId ";
        return template.queryForObject(query, namedParameters,
                BeanPropertyRowMapper.newInstance(Resume.class));
    }

    public int saveResume(Resume resume) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("jobseeker_id", resume.getJobseekerId());
        paramMap.put("name", resume.getName());
        paramMap.put("city", resume.getCity());
        paramMap.put("description", resume.getDescription());
        paramMap.put("experience", resume.getExperience());
        paramMap.put("previousJobs", resume.getPreviousJobs());
        paramMap.put("email", resume.getEmail());

        String query = "INSERT INTO resume(jobseeker_id,name,city,description,experience,previous_jobs,email) "
                + "VALUES(:jobseekerId:name, :city, :description, :experience, :previousJobs, :email)";
        return template.update(query, paramMap);
    }

    void updateResume(Resume resume) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("jobseeker_id", resume.getJobseekerId());
        paramMap.put("name", resume.getName());
        paramMap.put("city", resume.getCity());
        paramMap.put("description", resume.getDescription());
        paramMap.put("experience", resume.getExperience());
        paramMap.put("previousJobs", resume.getPreviousJobs());
        paramMap.put("email", resume.getEmail());
        String query = "update resume set jobseekerId=:jobseeker_Id,name=:name,username=:username,password=:password,email=:email,dob=:dob,desc=:desc,prev_salary=:prevSalary where jobseeker_id=:jobseekerId";
        template.update(query, paramMap);
    }
}
