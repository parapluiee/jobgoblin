package com.oscorp.jobgoblin.recruiter;

import com.oscorp.jobgoblin.company.Company;
import com.oscorp.jobgoblin.misc.Recruiter_Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RecruiterService {
    @Autowired
    RecruiterRepository repo;
    public List<Recruiter> getAllRecruiters() {
        return repo.findAll();
    }
    public Recruiter getRecruiter(long id) {
        return repo.getRecruiterById(   id);
    }

    void deleteRecruiter(long id) {
        repo.deleteRecruiterById(id);
    }
    public List<Company> getRecruiterCompaneis(long id)
    {
        List<Recruiter_Company> recruiter_companies = repo.getByRec(id);
        List<Company> companies = new ArrayList<>();
        for(int i =0;i<recruiter_companies.size();i++){
            System.out.println("THIS IS THE ID: "+recruiter_companies.get(i).getComid());
            Company comp = repo.getCompanyByID(recruiter_companies.get(i).getRecid());
            companies.add(comp);
        }
        return companies;
    }

    void saveRecruiter(Recruiter rec) {
        repo.saveRecruiter(rec);
    }

    void updateRecruiter(Recruiter rec) {
        repo.updateRecruiter(rec);
    }

}
