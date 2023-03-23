package com.oscorp.jobgoblin.job;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
@Repository
public class JobRepository {
    @Autowired
    NamedParameterJdbcTemplate template;
    //for testing
    List<Job> findAll(){
        String query = "select id, name, descr, companyID, recruiterID, rating, num_Ratings, date_Posted, salary_High, salary_Low, quizID from job";
        return template.query(query,
                   (result, rowNum)
                -> new Job(result.getLong("id"), result.getString("name"), result.getString("descr"), result.getLong("companyID"), result.getLong("recruiterID"), result.getDouble("" +
                        "rating"), result.getInt("num_Ratings"), result.getString("date_Posted"), result.getInt("salary_High"), result.getInt("salary_Low"), result.getLong("quizID")));

    }

    public int saveJob(Job job){
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", job.getName());
        paramMap.put("descr", job.getDescr());
        paramMap.put("companyID", job.getCompanyID());
        paramMap.put("recruiterID", job.getRecruiterID());
        paramMap.put("rating", job.getRating());
        paramMap.put("numRatings", job.getNumRatings());
        paramMap.put("datePosted", job.getDatePosted());
        paramMap.put("salaryHigh", job.getSalaryHigh());
        paramMap.put("salaryLow", job.getSalaryLow());
        paramMap.put("quizID", job.getQuizID());
        String query = "INSERT INTO job(name, descr, companyID, recruiterID, rating, num_Ratings, date_Posted, salary_High, salary_Low, quizID) VALUES(:name, :descr, :companyID, :recruiterID, :rating, :numRatings, :datePosted, :salaryHigh, :salaryLow, :quizID)";
        return template.update(query, paramMap);
    }

    public Job getJobByID(long id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        String query = "select * from job where id=:id";
        return template.queryForObject(query, namedParameters, BeanPropertyRowMapper.newInstance(Job.class));
    }

    void deleteJobByID(long id){
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        String query = "delete from job where id=:id";
        template.update(query, namedParameters);
    }

    void updateJob(Job job){
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", job.getId());
        paramMap.put("name", job.getName());
        paramMap.put("descr", job.getDescr());
        paramMap.put("companyID", job.getCompanyID());
        paramMap.put("recruiterID", job.getRecruiterID());
        paramMap.put("rating", job.getRating());
        paramMap.put("numRatings", job.getNumRatings());
        paramMap.put("datePostjobed", job.getDatePosted());
        paramMap.put("salaryHigh", job.getSalaryHigh());
        paramMap.put("salaryLow", job.getSalaryLow());
        paramMap.put("quizID", job.getQuizID());
        String query = "update job set name=:name, descr=:descr, companyID=:companyID, recruiterID=:recruiterID, rating=:rating, " +
                "num_Ratings=:numRatings, date_Posted=:datePosted, salary_High=:salaryHigh, salary_Low=:salaryLow, quizID=:quizID where id=:id";
        template.update(query, paramMap);
    }
}
