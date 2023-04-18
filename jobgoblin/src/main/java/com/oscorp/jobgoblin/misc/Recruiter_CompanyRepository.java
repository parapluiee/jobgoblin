package com.oscorp.jobgoblin.misc;

import com.oscorp.jobgoblin.recruiter.Recruiter;
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
public class Recruiter_CompanyRepository {
    @Autowired
    NamedParameterJdbcTemplate template;

    List<Recruiter_Company> getByRec(long recid) {
        String query = "select recid, comid, rel from recruiter_company where recid = " + recid;
        return template.query(query,
                (result, rowNum)
                        -> new Recruiter_Company(result.getLong("recid"),
                        result.getLong("comid"), result.getInt("rel")));
    }
    List<Recruiter_Company> getByCom(long comid) {
        String query = "select recid, comid, rel from recruiter_company where comid = " + comid;
        return template.query(query,
                (result, rowNum)
                        -> new Recruiter_Company(result.getLong("recid"),
                        result.getLong("comid"), result.getInt("rel")));
    }

    int getRel(long comid, long recid){
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue(
                "recid", recid).addValue("comid", comid);
        String query = "select * from recruiter where recid=:recid and comid=:comid";
        return template.queryForObject(query, namedParameters,
                BeanPropertyRowMapper.newInstance(Integer.class)).intValue();
    }

    List<Recruiter> getRecwoRel(long comid) {
        String query = "select recid, comid, rel from recruiter where recid not in " +
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
}
