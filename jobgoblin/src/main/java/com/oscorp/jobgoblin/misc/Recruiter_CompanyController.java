package com.oscorp.jobgoblin.misc;
import com.oscorp.jobgoblin.recruiter.RecruiterService;
import com.oscorp.jobgoblin.recruiter.Recruiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/rec_com")
public class Recruiter_CompanyController {

    @Autowired
    private Recruiter_CompanyService service;

    @Autowired RecruiterService recService;
    @GetMapping("/recruit")
    public String getRecruiter(Map<String, Long> pathVarsMap, Model model) {
        Recruiter rec = recService.getRecruiter(pathVarsMap.get("recid"));
        model.addAttribute("recruiter", rec);
        model.addAttribute("comid", pathVarsMap.get("comid"));

        return "rec_com/recruiter-detail";
    }
    @GetMapping("/recruiters/comid={comid}")
    public String recruitRecruiter(@PathVariable long comid, Model model){
        model.addAttribute("recruiterList", recService.getAllRecruiters());
        return "rec_com/list-recruiters-comid.html";
    }

    @GetMapping("/recruiterswo/comid={comid}")
    public String recruitList(@PathVariable long comid, Model model){
        model.addAttribute("recruiterList", service.getRecwoRel(comid));
        model.addAttribute("comid", comid);
        model.addAttribute("reccom", new Recruiter_Company(comid, 0, 0));
        return "list-recruiter-comid.html";
    }

}
