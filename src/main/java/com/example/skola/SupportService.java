package com.example.skola;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SupportService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String toEmail, String name)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("mmacibuvide@gmail.com");
        message.setTo(toEmail);

        message.setText("Hello,\n\nThank you for contacting support. We have received your message and will get back to you shortly.\n\nBest regards,\nThe Support Team");
        message.setSubject(name + ": " + "Support Ticket");

        mailSender.send(message);
    }

    public void ReciveEmail(String body, String fromEmail, String name)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("mmacibuvide@gmail.com");
        message.setTo("mmacibuvide@gmail.com");
        message.setText(body + "\n" + "Message sent from:" + "\n" + fromEmail);
        message.setSubject(name + ": " + "Support Ticket");

        mailSender.send(message);
    }

    public void forgotPasswordMail(String toEmail, String Password)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("mmacibuvide@gmail.com");
        message.setTo(toEmail);
        message.setText("Password:\n" + Password);
        message.setSubject("Password change.");

        mailSender.send(message);
    }
    public void ContactUsMail(String body, String fromEmail, String number, String name)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("mmacibuvide@gmail.com");
        message.setTo("mmacibuvide@gmail.com");
        message.setText(body + "\n" + "Message sent from:" + "\n" + fromEmail + "\n" + number);
        message.setSubject(name + " Contact Form");

        mailSender.send(message);
    }
}
