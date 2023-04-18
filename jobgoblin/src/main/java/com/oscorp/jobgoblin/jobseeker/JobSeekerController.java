package com.oscorp.jobgoblin.jobseeker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Maximilian
 */

@Controller
@RequestMapping("/jobseeker")
public class JobSeekerController {
    
    @Autowired
    JobSeekerService service;

    @GetMapping("/all")
    public String getAllJobSeekers(Model model) {
        model.addAttribute("jobseekerList", service.getAllJobSeekers());
        return "jobseeker/list-jobseekers";
    }

    @GetMapping("/id={jobseekerId}")
    public String getJobSeeker(@PathVariable long jobseekerId, Model model) {
        model.addAttribute("jobseeker", service.getJobSeeker(jobseekerId));
        return "jobseeker/jobseeker-detail";
    }

    @GetMapping("/delete/id={jobseekerId}")
    public String deleteJobSeeker(@PathVariable long jobseekerId, Model model) {
        service.deleteJobSeeker(jobseekerId);
        return "redirect:/jobseeker/all";
    }

    @PostMapping("/create")
    public String createJobSeeker(JobSeeker jobseeker) {

        service.saveJobSeeker(jobseeker);
        return "redirect:/jobseeker/all";
    }

    @PostMapping("/update")
    public String updateJobSeeker(JobSeeker jobseeker) {
        service.saveJobSeeker(jobseeker);
        return "redirect:/jobseeker/all";
    }

    @GetMapping("/new-jobseeker")
    public String newJobSeekerForm(Model model) {
        return "jobseeker/new-jobseeker";
    }

    @GetMapping("/update/id={jobseekerId}")
    public String updateJobSeekerForm(@PathVariable long jobseekerId, Model model) {
        model.addAttribute("jobseeker", service.getJobSeeker(jobseekerId));
        return "jobseeker/update-jobseeker";
    }
}
