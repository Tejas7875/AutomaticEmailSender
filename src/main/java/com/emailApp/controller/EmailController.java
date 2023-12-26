package com.emailApp.controller;

import com.emailApp.Exception.EmailExistsException;
import com.emailApp.Exception.InvalidEmailException;
import com.emailApp.entity.EmailEntity;
import com.emailApp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Controller
//@RequestMapping("/email") // Add a base path for this controller
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
    public String saveEmail(@RequestParam String email, RedirectAttributes redirectAttributes) {
        try {
            emailService.saveEmail(email);
            return "redirect:addEmail";
        } catch (InvalidEmailException e) {
            redirectAttributes.addAttribute("error", "Invalid email format");
            redirectAttributes.addAttribute("hasError", true); // Add a flag indicating an error
            return "redirect:addEmail"; // Redirect to the addEmail page with an error message
        } catch (EmailExistsException e) {
            redirectAttributes.addAttribute("error", "Email already exists");
            redirectAttributes.addAttribute("hasError", true); // Add a flag indicating an error
            return "redirect:addEmail"; // Redirect to the addEmail page with an error message
        }
    }

    @GetMapping("/listEmails")
    public String listEmails(Model model) {
        List<EmailEntity> emails = emailService.getAllEmails();
        model.addAttribute("emails", emails);
        System.out.println("Emails are : " +emails);
        return "listEmails";
    }

    @RequestMapping(value = "/deleteEmail", method = RequestMethod.POST)
    public String deleteEmail(@RequestParam("id") String id) {
        emailService.deleteEmailById(id);
        return "redirect:/listEmails"; // Redirect to the email list page
    }

        @PostMapping("/sendEmail")
        public ResponseEntity<String> sendEmail(
                @RequestParam String from,
                @RequestParam String subject,
                @RequestParam String text,
                @RequestParam(required = false) MultipartFile file) {
            System.out.println("Invoked");
            List<String> toEmails = emailService.getRecipientEmailsFromDatabase(); // Fetch recipient emails from the database

            try {
                if (toEmails != null && !toEmails.isEmpty()) {
                    for (String toEmailFromDb : toEmails) {
                        try {
                            if (file != null && !file.isEmpty()) {
                                File attachment = convertMultiPartToFile(file);
                                System.out.println("Emails sent to = " + toEmailFromDb);
                                emailService.sendEmailWithAttachment(toEmailFromDb, from, subject, text, attachment);
                            } else {
                                emailService.sendEmail(toEmailFromDb, from, subject, text);
                            }
                        } catch (Exception e) {
                            // Log or handle exceptions for individual emails if needed
                            e.printStackTrace();
                        }
                    }
                    return ResponseEntity.ok("Emails sent successfully.");
                } else {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No recipient emails found.");
                }
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send emails.");
            }
        }

    public static File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        }
        return convertedFile;
    }

}
