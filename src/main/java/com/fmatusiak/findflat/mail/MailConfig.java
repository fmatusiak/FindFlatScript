package com.fmatusiak.findflat.mail;

import java.util.Properties;

public class MailConfig {

    private String username;
    private String password;
    private String webisteName;

    public MailConfig(String username, String password, String websiteName) {
        this.username = username;
        this.password = password;
        this.webisteName = websiteName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getWebisteName() {
        return webisteName;
    }

    public Properties getConfigurationPropertiesMail() {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        return properties;
    }


}
