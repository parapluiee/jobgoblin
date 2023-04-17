package com.oscorp.jobgoblin.misc;

import com.oscorp.jobgoblin.recruiter.Recruiter;
import com.oscorp.jobgoblin.recruiter.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/rec_job")
public class Recruiter_JobController {
    @Autowired
    private Recruiter_JobService service;
    @Autowired
    RecruiterService recService;
    @GetMapping("/recruit")
    public String getRecruiter(Map<String, Long> pathVarsMap, Model model) {
        Recruiter rec = recService.getRecruiter(pathVarsMap.get("recid"));
        model.addAttribute("recruiter", rec);
        model.addAttribute("jobid", pathVarsMap.get("jobid"));

        return "rec_job/recruiter-detail";
    }
    @GetMapping("/recruiters/jobid={jobid}")
    public String recruitRecruiter(@PathVariable long jobid, Model model){
        model.addAttribute("recruiterList", recService.getAllRecruiters());
        return "rec_job/list-recruiters-jobid.html";
    }

    @GetMapping("/recruiterswo/jobid={jobid}")
    public String recruitList(@PathVariable long jobid, Model model){
        model.addAttribute("recruiterList", service.getRecwoRel(jobid));
        model.addAttribute("jobid", jobid);
        model.addAttribute("recjob", new Recruiter_Company(jobid, 0, 0));
        return "list-recruiter-jobid.html";
    }
}
