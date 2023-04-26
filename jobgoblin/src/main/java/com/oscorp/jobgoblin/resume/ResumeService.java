package com.oscorp.jobgoblin.resume;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Maximilian
 */

@Service
public class ResumeService {
    @Autowired
    protected ResumeRepository repo;
    public List<Resume> getAllResumes(){
        return repo.findAll();
    }
    public Object getResumeByJobseekerId(long jobseekerId){
        return repo.getResumeByJobSeekerId(jobseekerId);
    }
    public void saveResume(Resume resume){
        repo.saveResume(resume);
    }
    public void updateResume(Resume resume){
        repo.updateResume(resume);
    }
}
