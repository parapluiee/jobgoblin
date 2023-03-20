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
        ArrayList<Job> outlist = new ArrayList<>();
        outlist.add(new Job("bruh", "bruh", 30, 30, 1.2, 4000, new Date(3), 30, 20, 40));
        return outlist;
        //String query = "select id, name, desc, companyID, recruiterID, rating, numratings, dateposted, salaryhigh, salarylow, quizid";
        /*return template.query(query,
                   (result, rowNum)
                -> new Job(result.getLong("id"), result.getString("name"), result.getString("desc"), result.getLong("companyID"), result.getLong("recruiterID"), result.getDouble("" +
                        "rating"), result.getInt("numratings"), result.getDate("dateposted"), result.getInt("salaryhigh"), result.getInt("salarylow"), result.getLong("quizid")));
        */
    }

}
