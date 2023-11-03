package com.emailApp;

import com.emailApp.email.GEmailSender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.File;
import java.util.Properties;

@SpringBootApplication
public class EmailAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailAppApplication.class, args);

		GEmailSender gEmailSender = new GEmailSender();
		System.out.println("Preparing to send message");

		String text = "Sending from a java based program with attachment";
		String subject = "From Java with attachment";
		String to = "tejas.mulze@gmail.com";
		String from = "tejas.inexture123@gmail.com";
			File file = new File("/home/root415/Documents/TEJAS_AADHAR.pdf");

//		boolean b = gEmailSender.sendEmailWithAttachment(to,from,subject,text,file);
//
//		if (b)
//		{
//			System.out.println("Email Sent Successfully");
//		}
//		else
//		{
//			System.out.println("There is a problem in process of sending email...");
//		}

	}



}
