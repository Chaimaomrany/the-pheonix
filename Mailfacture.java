/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;



/**
 *
 * @author Sabrine
 */
public class Mailfacture {
        
    public void SendMail(String mail) {
        
        final String username = "tabaani.app@gmail.com";
        final String password = "tabaani2021";
 
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("tabaani.app@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(mail)
            );
            message.setSubject("Concernat l ajout de votre zone de loisir dans l application guide touristique");
            message.setText("Dear Zone de Loisir," + "\n\n We sent this mail Just to say HI and let you know that your zone is added succesfully in our APP");
            Transport.send(message);
            System.out.println("Done");
        } catch (MessagingException e) {
            e.printStackTrace();
                System.out.println("ereur mailer");
        }
    }
}