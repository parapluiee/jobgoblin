package com.oscorp.jobgoblin.jobseeker_job;

import com.oscorp.jobgoblin.recruiter.Recruiter;
import com.oscorp.jobgoblin.recruiter.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Map;

@Controller
@RequestMapping("/jobs_job")
public class Jobseeker_JobController {

    @Autowired
    private Jobseeker_JobService service;

    @GetMapping("/create-relation")
    String createRelation(Model model){
        return "/jobseeker_job/test.html";
    }

    @PostMapping("/create")
    String saveJobsjob(Jobseeker_Job jobseeker_job){
        service.saveJobsjob(jobseeker_job);
        return "redirect:/jobs_job/create-relation";
    }
    @PostMapping("/update")
    String updateJobsjob(Jobseeker_Job jobseeker_job){
        service.updateJobsjob(jobseeker_job);
        return "redirect:/jobs_job/create-relation";
    }

    @PostMapping("/delete")
    String deleteJobsjob(Jobseeker_Job jobseeker_job){
        service.delreccom(jobseeker_job.getJobsid(), jobseeker_job.getJobid());
        return "redirect:/jobs_job/create-relation";
    }


}
