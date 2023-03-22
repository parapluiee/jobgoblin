package com.oscorp.jobgoblin.recruiter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RecruiterRepository {
    @Autowired
    NamedParameterJdbcTemplate template;

    List<Recruiter> findAll() {
        String query = "select id, name,email,description,start_date,rating from recruiter";
        return template.query(query,
                (result, rowNum)
                        -> new Recruiter(result.getLong("id"),
                        result.getString("name"), result.getString(
                        "email"),result.getString(
                        "description"),result.getString(
                        "start_date"),result.getDouble(
                        "rating")));
    }

    public Recruiter getRecruiterById(long id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue(
                "id", id);
        String query = "select * from recruiter where id=:id ";
        return template.queryForObject(query, namedParameters,
                BeanPropertyRowMapper.newInstance(Recruiter.class));
    }

    public int saveRecruiter(Recruiter recruiter) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", recruiter.getName());
        paramMap.put("email", recruiter.getEmail());
        paramMap.put("description", recruiter.getDescription());
        paramMap.put("startDate", recruiter.getStartDate());
        paramMap.put("rating", recruiter.getRating());
        String query = "INSERT INTO recruiter(name,email,description,start_date,rating) " +
                "VALUES(:name, :email, :description, :startDate, :rating)";
        return template.update(query, paramMap);
    }

    void deleteRecruiterById(long id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue(
                "id", id);
        String query = "delete from recruiter where id=:id";
        template.update(query, namedParameters);
    }

    void updateRecruiter(Recruiter recruiter) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", recruiter.getId());
        paramMap.put("name", recruiter.getName());
        paramMap.put("email", recruiter.getEmail());
        paramMap.put("description", recruiter.getDescription());
        paramMap.put("startDate", recruiter.getStartDate());
        paramMap.put("rating", recruiter.getRating());
        String query = "update recruiter set name=name, email=email, description=description,start_date=startDate, rating=rating, where id=id ";
        template.update(query, paramMap);
    }
}
