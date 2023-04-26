package com.oscorp.jobgoblin.jobseeker;

import com.oscorp.jobgoblin.job.JobService;
import com.oscorp.jobgoblin.resume.Resume;
import com.oscorp.jobgoblin.resume.ResumeService;
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
@RequestMapping("jobseeker")
public class JobSeekerController {

    @Autowired
    JobSeekerService service;
    @Autowired
    JobService jobservice;
    @Autowired
    ResumeService resumeservice;

    @GetMapping("/job/all")
    public String getAllJobs(Model model) {
        model.addAttribute("jobList", jobservice.getAllJobs());
        return "jobseeker/list-jobs-jseeker";
    }

    @GetMapping("/all")
    public String getAllJobSeekers(Model model) {
        model.addAttribute("jobseekerList", service.getAllJobSeekers());
        return "jobseeker/list-jobseekers-main";
    }

    @PostMapping("/resume/create")
    public String createJobSeekerResume(Resume resume) {
        resumeservice.saveResume(resume);
        return "redirect:/jobseeker/all";
    }

    @PostMapping("/resume/update")
    public String updateJobSeekerResume(Resume resume) {
        resumeservice.updateResume(resume);
        return "redirect:/jobseeker/resume/id=" + resume.getJobseekerId();
    }

    @GetMapping("/resume/id={jobseekerId}")
    public String getResume(Model model, @PathVariable long jobseekerId) {
        model.addAttribute("resume", resumeservice.getResumeByJobseekerId(jobseekerId));
        return "resume/resume-detail";
    }

    @GetMapping("/resume")
    public String newJobSeekerResumeForm(Model model) {
        return "resume/new-resume";
    }

    @GetMapping("/resume/update/id={jobseekerId}")
    public String updateJobSeekerResumeForm(@PathVariable long jobseekerId, Model model) {
        model.addAttribute("jobseeker", resumeservice.getResumeByJobseekerId(jobseekerId));
        return "resume/update-resume";
    }

    @GetMapping("/id={jobseekerId}")
    public String getJobSeeker(@PathVariable long jobseekerId, Model model) {
        model.addAttribute("jobseeker", service.getJobSeeker(jobseekerId));
        return "jobseeker/jobseeker-profile";
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
        service.updateJobSeeker(jobseeker);
        return "redirect:/jobseeker/id=" + jobseeker.getJobseekerId();
    }

    @GetMapping("/new-jobseeker")
    public String newJobSeekerForm(Model model) {
        return "/jobseeker/new-jobseeker";
    }

    @GetMapping("/update/id={jobseekerId}")
    public String updateJobSeekerForm(@PathVariable long jobseekerId, Model model) {
        model.addAttribute("jobseeker", service.getJobSeeker(jobseekerId));
        return "jobseeker/update-jobseeker";
    }
}
