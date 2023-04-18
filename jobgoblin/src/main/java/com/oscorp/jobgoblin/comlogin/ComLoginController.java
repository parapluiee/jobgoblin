package com.oscorp.jobgoblin.comlogin;
import com.oscorp.jobgoblin.company.CompanyService;
import com.oscorp.jobgoblin.misc.Recruiter_Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/comlogin")
public class ComLoginController {
    @Autowired
    private ComLoginService service;

    @PostMapping("/loginreq")
    public String logreq(ComLogin request){
        try {
            Long comid = service.logAttempt(request);
            return "redirect:/company/id="+comid;
        }
        catch (Exception ex){
            return "redirect:/company/login";
        }
    }

}
