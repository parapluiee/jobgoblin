package com.oscorp.jobgoblin.comlogin;
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
public class ComLoginRepo {
    @Autowired
    NamedParameterJdbcTemplate template;

    Long checkLogin(ComLogin attempt) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue(
                "pass", attempt.getPass()).addValue("user", attempt.getUser());
        String query = "select comid from comlogin where pass=:pass and user=:user";
        return template.queryForObject(query, namedParameters,
                Long.class);
    }
}
