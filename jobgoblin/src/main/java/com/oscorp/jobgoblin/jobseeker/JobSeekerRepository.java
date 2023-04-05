package com.oscorp.jobgoblin.jobseeker;

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
        String query = "select id, name,username,email,prevSalary from jobseeker";
        return template.query(query,
                (result, rowNum)
                        -> new JobSeeker(result.getLong("id"),
                        result.getString("name"), result.getString(
                        "username"),result.getString(
                        "email"),result.getDouble(
                        "prevSalary")));
    }

    public JobSeeker getJobSeekerById(long id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue(
                "id", id);
        String query = "select * from jobseeker where id=:id ";
        return template.queryForObject(query, namedParameters,
                BeanPropertyRowMapper.newInstance(JobSeeker.class));
    }

    public int saveJobSeeker(JobSeeker jseeker) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", jseeker.getName());
        paramMap.put("username", jseeker.getUsername());
        paramMap.put("email", jseeker.getEmail());
        paramMap.put("prevSalary", jseeker.getPrevSalary());
        String query = "INSERT INTO jobseeker(name,username,email,prevSalary) " +
                "VALUES(:name, :username, :email, :prevSalary)";
        return template.update(query, paramMap);
    }

    void deleteJobSeekerById(long id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue(
                "id", id);
        String query = "delete from jobSeeker where id=:id";
        template.update(query, namedParameters);
    }

    void updateJobSeeker(JobSeeker jseeker) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", jseeker.getName());
        paramMap.put("username", jseeker.getUsername());
        paramMap.put("email", jseeker.getEmail());
        paramMap.put("prevSalary", jseeker.getPrevSalary());
        String query = "update jobseeker set name=:name,username=:username,email=:email,prevSalary=:prevSalary where id=:id";
        template.update(query, paramMap);
    }
}
