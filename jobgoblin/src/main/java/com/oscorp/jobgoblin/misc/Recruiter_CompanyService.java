package com.oscorp.jobgoblin.misc;

import com.oscorp.jobgoblin.recruiter.Recruiter;
import com.oscorp.jobgoblin.recruiter.RecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Recruiter_CompanyService {
    @Autowired
    Recruiter_CompanyRepository repo;

    List<Recruiter_Company> getByRec(long recid){
        return repo.getByRec(recid);
    }

    List<Recruiter_Company> getByCom(long comid) {
        return repo.getByCom(comid);
    }

    int getRel(long comid, long recid){
        return repo.getRel(comid, recid);
    }
    List<Recruiter> getRecwoRel(long comid){
        return repo.getRecwoRel(comid);
    }
}