package com.oscorp.jobgoblin.resume;

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
@RequestMapping("/resume")
public class ResumeController {

    /*@Autowired
    //private ResumeService service;
    @GetMapping("/id={resumeId}")
    public String resumeView(Model model, @PathVariable long resumeId){
        //model.addAttribute();
        return "resume-detail";
    }*/
}
