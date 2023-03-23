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
    JobSeekerService jseekerService;

    @GetMapping("/all")
    public String getAllJobSeekers(Model model) {
        model.addAttribute("jobseekerList", jseekerService.getAllJobSeekers());
        return "jobseeker/list-jobseekers";
    }

    @GetMapping("/id={jseekerId}")
    public String getJobSeeker(@PathVariable long jobseekerId, Model model) {
        model.addAttribute("jobseeker", jseekerService.getJobSeeker(jobseekerId));
        return "jobseeker/jobseeker-detail";
    }

    @GetMapping("/delete/id={jobseekerId}")
    public String deleteJobSeeker(@PathVariable long jobseekerId, Model model) {
        jseekerService.deleteJobSeeker(jobseekerId);
        return "redirect:/jobseeker/all";
    }

    @PostMapping("/create")
    public String createJobSeeker(JobSeeker jobseeker) {

        jseekerService.saveJobSeeker(jobseeker);
        return "redirect:/jobseeker/all";
    }

    @PostMapping("/update")
    public String updateJobSeeker(JobSeeker jobseeker) {
        jseekerService.saveJobSeeker(jobseeker);
        return "redirect:/jobseeker/all";
    }

    @GetMapping("/new-jobseeker")
    public String newJobSeekerForm(Model model) {
        return "jobseeker/new-jobseeker";
    }

    @GetMapping("/update/id={jseekerId}")
    public String updateJobSeekerForm(@PathVariable long jobseekerId, Model model) {
        model.addAttribute("jobseeker", jseekerService.getJobSeeker(jobseekerId));
        return "jobseeker/update-jobseeker";
    }
}
