package com.supportportal.service;

import com.sun.mail.smtp.SMTPTransport;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

import static com.supportportal.constant.EmailConstant.*;
import static javax.mail.Message.RecipientType.CC;
import static javax.mail.Message.RecipientType.TO;

@Service
public class EmailService {

    public void sendNewPasswordEmail(String firstName, String password, String email) throws MessagingException {
//        Message message = createEmail(firstName, password, email);
//        SMTPTransport smtpTransport = (SMTPTransport) getEmailSession().getTransport(SIMPLE_MAIL_TRANSFER_PROTOCOL);
//        smtpTransport.connect(GMAIL_SMTP_SERVER, USERNAME, PASSWORD);
//        smtpTransport.sendMessage(message, message.getAllRecipients());
//        smtpTransport.close();
//        Transport
    }

    private Message createEmail(String firstName, String password, String email) throws MessagingException {
//        Message message = new MimeMessage(getEmailSession());
//        message.setFrom(new InternetAddress(FROM_EMAIL));
//        message.setRecipients(TO, InternetAddress.parse(email   , false));
//        message.setRecipients(CC, InternetAddress.parse(CC_EMAIL, false));
//        message.setSubject(EMAIL_SUBJECT);
//        message.setText("Hello " + firstName + ", \n \n Your new account password is: " + password + "\n \n The Support Team");
//        message.setSentDate(new Date());
//        message.saveChanges();
//        return message;
        MimeMessage message = new MimeMessage(getEmailSession());
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("18600097@student.hcmus."));
        message.setSubject("Testing Subject");
        message.setText("Welcome to gpcoder.com");
        return message;
    }

    private Session getEmailSession() {
//        Properties properties = System.getProperties();
//        properties.put(SMTP_HOST, GMAIL_SMTP_SERVER);
//        properties.put(SMTP_AUTH, true);
//        properties.put(SMTP_PORT, DEFAULT_PORT);
//        properties.put(SMTP_STARTTLS_ENABLE, true);
//        properties.put(SMTP_STARTTLS_REQUIRED, true);
//        return Session.getInstance(properties, null);
        // Get properties object
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", 465);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.port", 465);
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("duongtanhuan2000@gmail.com"
                        , "hu@n13112000");
            }
        });
        return session;
    }
}
