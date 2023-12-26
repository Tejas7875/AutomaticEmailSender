package com.emailApp.service;

import com.emailApp.Exception.EmailExistsException;
import com.emailApp.Exception.InvalidEmailException;
import com.emailApp.JPA.EmailRepository;
import com.emailApp.entity.EmailEntity;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if (isValidEmail(email)) {
            if (emailRepository.existsByEmail(email))
            {
                throw new EmailExistsException("Email already exists");
            }
            else {
            emailEntity.setEmail(email);
            return emailRepository.save(emailEntity);
            }
        }
        else
        {
            throw new InvalidEmailException("Invalid email format");
        }
    }

    public EmailEntity getEmailById(String id) {
        return emailRepository.findById(id).orElse(null);
    }

    public void deleteEmailById(String email) {
        emailRepository.deleteById(email);
    }


    public static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.com$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    public boolean sendEmailWithAttachment(String to, String from, String subject, String text, File file)
    {


        boolean flag = false;


        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable",true);
        properties.put("mail.smtp.port","587");
        properties.put("mail.smtp.host","smtp.gmail.com");

        String username = "tejas.inexture123";
        String password = "davxmuwwslhsmfep";

        // Session get

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setFrom(new InternetAddress(from));
            message.setSubject(subject);

            MimeBodyPart part1 = new MimeBodyPart();
            part1.setText(text);

            MimeBodyPart part2 = new MimeBodyPart();
            part2.attachFile(file);

            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(part1);
            mimeMultipart.addBodyPart(part2);

            message.setContent(mimeMultipart);

            Transport.send(message);
            flag = true;

        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }



        return flag;

    }

    public boolean sendEmail(String to, String from, String subject, String text)
    {
        boolean flag = false;

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable",true);
        properties.put("mail.smtp.port","587");
        properties.put("mail.smtp.host","smtp.gmail.com");

        String username = "tejas.inexture123";
        String password = "davxmuwwslhsmfep";

        // Session get

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try
        {
            Message message = new MimeMessage(session);

            message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setFrom(new InternetAddress(from));
            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);
            flag = true;

        }

        catch (Exception e)
        {
            e.printStackTrace();
        }


        return flag;
    }


    public List<String> getRecipientEmailsFromDatabase() {
        List<EmailEntity> emailEntities = emailRepository.findAll();
        List<String> recipientEmails = new ArrayList<>();

        for (EmailEntity emailEntity : emailEntities) {
            // Assuming getEmail() returns the email address in EmailEntity
            recipientEmails.add(emailEntity.getEmail());
        }

        return recipientEmails;
    }


}
