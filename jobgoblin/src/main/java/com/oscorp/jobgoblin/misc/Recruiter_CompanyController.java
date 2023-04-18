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

import java.io.Console;
import java.util.ArrayList;
import java.util.Map;

@Controller
@RequestMapping("/rec_com")
public class Recruiter_CompanyController {

    @Autowired
    private Recruiter_CompanyService service;

    @Autowired RecruiterService recService;
    @GetMapping("/recruit/{recid}/{comid}")
    public String getRecruiter(@PathVariable Map<String, String> pathVarsMap, Model model) {
        System.out.println(Long.parseLong(pathVarsMap.get("recid")));
        Recruiter rec = recService.getRecruiter(Long.parseLong(pathVarsMap.get("recid")));
        model.addAttribute("recruiter", rec);
        model.addAttribute("comid", Long.parseLong(pathVarsMap.get("comid")));
        String relationship = "none";
        switch (service.getRel(Long.parseLong(pathVarsMap.get("comid")), Long.parseLong(pathVarsMap.get("recid")))) {
            case 0:{relationship = "Awaiting Response";
            }
            case 1:{relationship = "Hired";}
            case 2:{relationship = "Rejected";}
            }
        model.addAttribute("relationship", relationship);
        return "rec_com/recruiter-detail";
    }
    @GetMapping("/recruiters/comid={comid}")
    public String recruitRecruiter(@PathVariable long comid, Model model){
        ArrayList<Recruiter_Company> ids = new ArrayList(service.getByCom(comid));
        ArrayList<Recruiter> recruiters = new ArrayList<>();
        for (int i = 0; i < ids.size(); i++){
            recruiters.add(recService.getRecruiter(ids.get(i).getRecid()));
        }
        model.addAttribute("recruiterList", recruiters);

        return "rec_com/list-recruiters-comid.html";
    }

    @GetMapping("/recruiterswo/comid={comid}")
    public String recruitList(@PathVariable long comid, Model model){
        model.addAttribute("recruiterList", service.getRecwoRel(comid));
        model.addAttribute("comid", comid);
        model.addAttribute("reccom", new Recruiter_Company(comid, 0, 0));
        return "rec_com/list-recruiterswo-comid.html";
    }

    @GetMapping("/recruitrec/{comid}/{recid}")
    public String recruitRec(@PathVariable Map<String, String> pathVarsMap, Model model){
        model.addAttribute("recruiter", recService.getRecruiter(Long.parseLong(pathVarsMap.get("recid"))));
        model.addAttribute("comid", Long.parseLong(pathVarsMap.get("comid")));
        return "/rec_com/recruit-recruiter-detail.html";
    }

    @PostMapping("/newrel")
    public String newRelation(Recruiter_Company reccom){
        service.savereccom(reccom);
        return "redirect:/rec_com/recruiterswo/comid=" + reccom.getComid();
    }
}
