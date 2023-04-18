package com.oscorp.jobgoblin.recruiter;

import com.oscorp.jobgoblin.company.Company;
import com.oscorp.jobgoblin.misc.Recruiter_Company;
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
        paramMap.put("start_date", recruiter.getStartDate());
        paramMap.put("rating", recruiter.getRating());
        String query = "INSERT INTO recruiter(name,email,description,start_date,rating) " +
                "VALUES(:name, :email, :description, :start_date, :rating)";
        return template.update(query, paramMap);
    }

    void deleteRecruiterById(long id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue(
                "id", id);
        String query = "delete from recruiter where id=:id";
        template.update(query, namedParameters);
    }
    List<Recruiter_Company> getByRec(long recid) {
        String query = "select recid, comid, rel from recruiter_company where recid = " + recid;
        return template.query(query,
                (result, rowNum)
                        -> new Recruiter_Company(result.getLong("recid"),
                        result.getLong("comid"), result.getInt("rel")));
    }
    public Company getCompanyByID(long id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        String query = "select * from company where id=:id";
        return template.queryForObject(query, namedParameters, BeanPropertyRowMapper.newInstance(Company.class));
    }

    void updateRecruiter(Recruiter recruiter) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", recruiter.getId());
        paramMap.put("name", recruiter.getName());
        paramMap.put("email", recruiter.getEmail());
        paramMap.put("description", recruiter.getDescription());
        paramMap.put("start_date", recruiter.getStartDate());
        paramMap.put("rating", recruiter.getRating());
        String query = "update recruiter set name=:name, email=:email, description=:description,start_date=:start_date, rating=:rating where id=:id";
        template.update(query, paramMap);
    }
}
