package com.oscorp.jobgoblin.recruiter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecruiterService {
    @Autowired
    RecruiterRepository repo;
    List<Recruiter> getAllRecruiters() {
        return repo.findAll();
    }
    Object getRecruiter(long id) {
        return repo.getRecruiterById(   id);
    }

    void deleteRecruiter(long id) {
        repo.deleteRecruiterById(id);
    }

    void saveRecruiter(Recruiter rec) {
        repo.saveRecruiter(rec);
    }

    void updateRecruiter(Recruiter rec) {
        repo.updateRecruiter(rec);
    }

}
