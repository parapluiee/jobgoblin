package com.oscorp.jobgoblin.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompanyService {
    @Autowired
    CompanyRepository repo;

    List<Company> getAllCompanies() {return repo.findAll();}

    void saveCompany(Company company) {
        repo.saveCompany(company);}

    Object getCompany(long id){
        return repo.getCompanyByID(id);
    }

    void deleteCompany(long id){
        repo.deleteCompanyByID(id);
    }
    void updateCompany(Company company){
        repo.updateCompany(company);
    }
}
