package com.oscorp.jobgoblin.comlogin;

import com.oscorp.jobgoblin.company.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.oscorp.jobgoblin.misc.Recruiter_Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ComLoginService {
    @Autowired
    ComLoginRepo repo;

    Long logAttempt(ComLogin attempt){
        return repo.checkLogin(attempt);
    }
}
