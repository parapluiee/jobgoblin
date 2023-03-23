package com.oscorp.jobgoblin.company;

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
public class CompanyRepository {
    @Autowired
    NamedParameterJdbcTemplate template;
    //for testing
    List<Company> findAll(){
        String query = "select id, name, descr, email, founding_date, start_date, web_link, rating, num_Ratings from company";
        return template.query(query,
                   (result, rowNum)
                -> new Company(result.getLong("id"), result.getString("name"), result.getString("descr"), result.getString("email"), result.getString("founding_date"), result.getString("" +
                        "start_Date"), result.getString("web_link"), result.getDouble("rating"), result.getInt("num_Ratings")));

    }

    public int saveCompany(Company company){
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", company.getName());
        paramMap.put("descr", company.getDescr());
        paramMap.put("rating", company.getRating());
        paramMap.put("numRatings", company.getNumRatings());
        paramMap.put("email", company.getEmail());
        System.out.println(company.getFoundingDate());
        paramMap.put("foundingDate", company.getFoundingDate());
        paramMap.put("startDate", company.getStartDate());
        paramMap.put("weblink", company.getWebLink());
        String query = "INSERT INTO company(name, descr, rating, num_ratings, email, founding_Date, start_date, web_link) VALUES(:name, :descr, :rating, :numRatings, :email, :foundingDate, :startDate, :weblink)";
        return template.update(query, paramMap);
    }

    public Company getCompanyByID(long id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        String query = "select * from company where id=:id";
        return template.queryForObject(query, namedParameters, BeanPropertyRowMapper.newInstance(Company.class));
    }

    void deleteCompanyByID(long id){
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        String query = "delete from company where id=:id";
        template.update(query, namedParameters);
    }

    void updateCompany(Company company){
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", company.getId());
        paramMap.put("name", company.getName());
        paramMap.put("descr", company.getDescr());
        paramMap.put("rating", company.getRating());
        paramMap.put("numRatings", company.getNumRatings());
        paramMap.put("email", company.getEmail());
        paramMap.put("foundingDate", company.getFoundingDate());
        paramMap.put("startDate", company.getStartDate());
        paramMap.put("weblink", company.getWebLink());
        String query = "update company set name=:name, descr=:descr, rating=:rating, " +
                "num_Ratings=:numRatings, email=:email, founding_Date=:foundingDate, start_date=:startDate, web_link=:weblink where id=:id";
        template.update(query, paramMap);
    }
}
