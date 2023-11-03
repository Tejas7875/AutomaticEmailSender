package com.emailApp.service;

import com.emailApp.JPA.EmailRepository;
import com.emailApp.entity.EmailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {
    private final EmailRepository emailRepository;

    @Autowired
    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    public List<EmailEntity> getAllEmails() {
        return emailRepository.findAll();
    }

    public EmailEntity saveEmail(String email) {
        EmailEntity emailEntity = new EmailEntity();
        emailEntity.setEmail(email);
        return emailRepository.save(emailEntity);
    }

    public EmailEntity getEmailById(Long id) {
        return emailRepository.findById(id).orElse(null);
    }

    public void deleteEmailById(Long id) {
        emailRepository.deleteById(id);
    }




}
