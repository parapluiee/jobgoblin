package com.oscorp.jobgoblin.company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService service;

    @GetMapping("/all")
    public String getAllCompanies(Model model){
        model.addAttribute("companyList", service.getAllCompanies());
        return "company/list-companies.html";
    }

    @PostMapping("/create")
    public String createCompany(Company company){
        service.saveCompany(company);
        return "redirect:/company/all";
    }
    @GetMapping("delete/id={id}")
    public String deleteCompany(@PathVariable long id, Model model) {
        service.deleteCompany(id);
        return "redirect:/company/all";
    }
    @GetMapping("/id={id}")
    public String getCompany(@PathVariable long id, Model model){
        model.addAttribute("company", service.getCompany(id));
        return "company/company-detail";
    }
    @GetMapping("new-company")
    public String newCompany(){
        return "company/new-company.html";
    }

    @GetMapping("/update/id={id}")
    public String updateCompanyForm(@PathVariable long id, Model model) {
        model.addAttribute("company", service.getCompany(id));
        return "company/update-company";
    }
    @PostMapping("/update-company")
    public String updateCompany(Company company){
        service.updateCompany(company);
        return "redirect:/company/all";
    }
}
