package com.controller;

import com.MyConstants;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
@Controller
public class SimpleEmailExampleController {
 
    @Autowired
    public JavaMailSender emailSender;
 
    @ResponseBody
    @RequestMapping("/sendSimpleEmail")
    public String sendSimpleEmail() {
    	SimpleMailMessage message = new SimpleMailMessage();
    	Calendar calendar = new GregorianCalendar();
		//calendar.roll(Calendar.DAY_OF_WEEK, 4);
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		if (day == 1 || day == 6) {
			message.setTo(MyConstants.FRIEND_EMAIL);
	        message.setSubject("Test Simple Email");
	        message.setText("Saturday||Sunday");
	        this.emailSender.send(message);
	        
	        return "Email Sent!";
		} 
		else {
			message.setTo(MyConstants.FRIEND_EMAIL);
	        message.setSubject("Test Simple Email");
	        message.setText("Work");
	        this.emailSender.send(message);
	        
	        return "Email Sent!";
		}
        
    }
 
}
