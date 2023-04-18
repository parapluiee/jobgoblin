package com.oscorp.jobgoblin.misc;

import com.oscorp.jobgoblin.company.Company;
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
                        -> new Recruiter_Company(result.getLong("comid"),
                        result.getLong("recid"), result.getInt("rel")));
    }

    int getRel(long comid, long recid){
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue(
                "recid", recid).addValue("comid", comid);
        System.out.println(recid + " " + comid);
        String query = "select rel from recruiter_company where recid=:recid and comid=:comid";
        return template.queryForObject(query, namedParameters,
                Integer.class);
    }

    List<Recruiter> getRecwoRel(long comid) {
        String query = "select * from recruiter where id not in " +
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

    public int savRecCom(Recruiter_Company reccomd){
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("comid", reccomd.getComid());
        paramMap.put("recid", reccomd.getRecid());
        paramMap.put("rel", reccomd.getRel());
        String query = "INSERT INTO recruiter_company(recid, comid, rel) VALUES(:recid, :comid, :rel)";
        return template.update(query, paramMap);
    }

    void updatereccom(Recruiter_Company rec_com){
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("recid", rec_com.getRecid());
        paramMap.put("comid", rec_com.getComid());
        paramMap.put("rel", rec_com.getRel());
        String query = "update recruiter_company set recid=:recid, comid=:comid, rel=:rel where recid:recid";
        template.update(query, paramMap);
    }
    void deletereccom(long recid, long comid){
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("recid", recid).addValue("comid", comid);
        String query = "delete from recruiter_company where recid=:recid and comid=:comid";
        template.update(query, namedParameters);
    }

}
