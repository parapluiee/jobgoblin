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
}
