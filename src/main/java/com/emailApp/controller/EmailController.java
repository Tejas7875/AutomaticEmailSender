package com.emailApp.controller;

import com.emailApp.entity.EmailEntity;
import com.emailApp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/email") // Add a base path for this controller
public class EmailController
{
    private final EmailService emailService;

    @GetMapping("/")
    public String index() {
        return "index";
    }


    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/addEmail")
    public String showEmailForm() {
        return "addEmail";
    }

    @GetMapping("/compose")
    public String compose() {
        return "compose";
    }

    @PostMapping("/saveEmail")
    public String saveEmail(@RequestParam String email) {
        emailService.saveEmail(email);
        return "redirect:/addEmail";
    }

    @GetMapping("/listEmails")
    public String listEmails(Model model) {
        List<EmailEntity> emails = emailService.getAllEmails();
        model.addAttribute("emails", emails);
        System.out.println("Emails are : " +emails);
        return "listEmails";
    }

    @RequestMapping(value = "/deleteEmail", method = RequestMethod.POST)
    public String deleteEmail(@RequestParam("id") Long id) {
        emailService.deleteEmailById(id);
        return "redirect:/listEmails"; // Redirect to the email list page
    }


}
