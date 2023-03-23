package com.oscorp.jobgoblin.recruiter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recruiter")
public class RecruiterController {

    @Autowired
    private RecruiterService service;

    @GetMapping("/all")
    public String getHomePage(Model model) {
        model.addAttribute("recruiterList", service.getAllRecruiters());
        return "recruiter/list-recruiters";
    }

    @GetMapping("/profile/id={id}")
    public String getRecruiter(@PathVariable long id, Model model) {
        model.addAttribute("recruiter", service.getRecruiter(id));
        return "recruiter/recruiter-detail";
    }

    @GetMapping("/profile/delete/id={id}")
    public String deleteRecruiter(@PathVariable long id, Model model) {
        service.deleteRecruiter(id);
        return "redirect:/recruiter/profile/id={id}";
    }

    @PostMapping("/create")
    public String createRecruiter(Recruiter rec) {
        service.saveRecruiter(rec);
        return "redirect:/recruiter/profile/id={rec.id}";
    }

    @PostMapping("/profile/update")
    public String updateRecruiter(Recruiter rec) {
        //service.updateRecruiter(rec);
        return "redirect:/recruiter/profile/id={id}";
    }

    @GetMapping("/new-recruiter")
    public String newRecruiterForm(Model model) {
        return "recruiter/new-recruiter";
    }

    @GetMapping("/profile/update/id={id}")
    public String updateRecruiterForm(@PathVariable long id, Model model) {
        model.addAttribute("recruiter", service.getRecruiter(id));
        return "recruiter/update-recruiter";
    }
}
