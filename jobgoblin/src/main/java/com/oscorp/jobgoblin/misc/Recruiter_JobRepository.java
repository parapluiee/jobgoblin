package com.oscorp.jobgoblin.misc;

import com.oscorp.jobgoblin.recruiter.Recruiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Recruiter_JobRepository {
    @Autowired
    NamedParameterJdbcTemplate template;

    List<Recruiter_Job> getByRec(long recid) {
        String query = "select recid, comid, rel from recruiter_job where recid = " + recid;
        return template.query(query,
                (result, rowNum)
                        -> new Recruiter_Job(result.getLong("recid"),
                        result.getLong("jobid"), result.getInt("rel")));
    }
    List<Recruiter_Job> getByJob(long jobid) {
        String query = "select recid, comid, rel from recruiter_company where jobid = " + jobid;
        return template.query(query,
                (result, rowNum)
                        -> new Recruiter_Job(result.getLong("recid"),
                        result.getLong("jobid"), result.getInt("rel")));
    }

    int getRel(long jobid, long recid){
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue(
                "recid", recid).addValue("jobid", jobid);
        String query = "select * from recruiter where recid=:recid and jobid=: jobid";
        return template.queryForObject(query, namedParameters,
                BeanPropertyRowMapper.newInstance(Integer.class)).intValue();
    }

    List<Recruiter> getRecwoRel(long jobid) {
        String query = "select recid, jobid, rel from recruiter where recid not in " +
                "(select recid from recruiter_company where jobid = " + jobid + ")";
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
