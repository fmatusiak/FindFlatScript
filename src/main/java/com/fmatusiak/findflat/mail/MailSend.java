package com.fmatusiak.findflat.mail;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Properties;

public class MailSend {

    private MailConfig mailConfig;

    public MailSend(MailConfig mailConfig) {
        this.mailConfig = mailConfig;
    }

    public void sendResultsUrlToMail(String fileNameFlatsUrl, String nameWebsite) {

        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        LocalDate localDate = LocalDate.now();

        try {
            Session session = getSessionMail(mailConfig.getUsername(), mailConfig.getPassword(), mailConfig.getConfigurationPropertiesMail());

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mailConfig.getUsername()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailConfig.getUsername()));
            message.setSubject("Find Flats Url " + nameWebsite + formatDate.format(localDate));
            message.setText(" ");

            MimeBodyPart messageBodyPart = new MimeBodyPart();

            Multipart multipart = new MimeMultipart();

            messageBodyPart = new MimeBodyPart();
            String file = fileNameFlatsUrl;
            DataSource source = new FileDataSource(file);
            messageBodyPart.setDataHandler(new DataHandler(source));
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);

            Transport.send(message);

            System.out.println("Sended to :" + mailConfig.getUsername());

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private Session getSessionMail(String username, String password, Properties properties) {
        return Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }
}

