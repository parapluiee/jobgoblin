package com.oscorp.jobgoblin.job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/job")
public class JobController {
    @Autowired
    private JobService service;

    @GetMapping("/all")
    public String getAllJobs(Model model){
        model.addAttribute("jobList", service.getAllJobs());
        return "job/list-jobs.html";
    }

    @PostMapping("/create")
    public String createJob(Job job){
        service.saveJob(job);
        return "redirect:/job/all";
    }
    @GetMapping("delete/id={id}")
    public String deleteJob(@PathVariable long id, Model model) {
        service.deleteJob(id);
        return "redirect:/job/all";
    }
    @GetMapping("/id={id}")
    public String getJob(@PathVariable long id, Model model){
        model.addAttribute("job", service.getJob(id));
        return "job/job-detail";
    }
    @GetMapping("new-job")
    public String newJob(){
        return "job/new-job.html";
    }

    @GetMapping("/update/id={id}")
    public String updateJobForm(@PathVariable long id, Model model) {
        model.addAttribute("job", service.getJob(id));
        return "job/update-job";
    }
    @PostMapping("/update-job")
    public String updateJob(Job job){
        service.updateJob(job);
        return "redirect:/job/all";
    }
}