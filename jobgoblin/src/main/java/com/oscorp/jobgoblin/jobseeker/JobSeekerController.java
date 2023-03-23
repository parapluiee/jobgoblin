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
    JobSeekerService bookService;

    @GetMapping("/all")
    public String getAllBooks(Model model) {
        model.addAttribute("bookList", bookService.getAllJobSeekers());
        return "book/list-books";
    }

    @GetMapping("/id={bookId}")
    public String getBook(@PathVariable long jseekerId, Model model) {
        model.addAttribute("book", bookService.getJobSeeker(jseekerId));
        return "book/book-detail";
    }

    @GetMapping("/delete/id={bookId}")
    public String deleteBook(@PathVariable long jseekerId, Model model) {
        bookService.deleteJobSeeker(jseekerId);
        return "redirect:/book/all";
    }

    @PostMapping("/create")
    public String createBook(JobSeeker book) {

        bookService.saveJobSeeker(book);
        return "redirect:/book/all";
    }

    @PostMapping("/update")
    public String updateBook(JobSeeker jseeker) {
        bookService.saveJobSeeker(jseeker);
        return "redirect:/book/all";
    }

    @GetMapping("/new-book")
    public String newJobSeekerForm(Model model) {
        return "book/new-book";
    }

    @GetMapping("/update/id={bookId}")
    public String updateJobSeekerForm(@PathVariable long jseekerId, Model model) {
        model.addAttribute("book", bookService.getJobSeeker(jseekerId));
        return "book/update-book";
    }
}
