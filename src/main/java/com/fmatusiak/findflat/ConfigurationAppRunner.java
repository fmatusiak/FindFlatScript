package com.fmatusiak.findflat;

import com.fmatusiak.findflat.configuration.ConfigureApplication;
import com.fmatusiak.findflat.mail.MailConfig;

import java.util.Scanner;

public class ConfigurationAppRunner {
    private static final String MAIL_CONFIGURATION = "mailConfig";
    private static final String FIND_FLATS_CONFIGURATION = "flatsConfig";

    public void configuration(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("<------- Configuration Script FindFlats -------> ");
        System.out.println("------------------------------------------------");
        System.out.println("-----------------EMAIL CONFIGURATION------------");
        System.out.println("Email adress: ");
        String emailAddress = scanner.next();
        System.out.println("Email password: ");
        String emailPassword = scanner.next();
        System.out.println("Choose website");
        String websiteName = scanner.next();
        System.out.println("------------------------------------------------");
        System.out.println("-----------------FLATS CONFIGURATION------------");
        System.out.println("------------------------------------------------");
        System.out.println("City: ");
        String city = scanner.next();

        System.out.println("Price from: ");
        String priceFrom = scanner.next();

        System.out.println("Price to: ");
        String priceTo = scanner.next();

        System.out.println("How rooms from: ");
        String howFromRooms = scanner.next();

        System.out.println("How rooms to: ");
        String howToRooms = scanner.next();

        System.out.println("Ok , it's all . Run Application FindFlats");
        System.out.println("-------------------------------------------");

        MailConfig mailConfig = new MailConfig(emailAddress, emailPassword, websiteName);

        ConfigureApplication configureApplication = new ConfigureApplication();
        configureApplication.setAccountMail(mailConfig);

        configureApplication.saveConfigurationFile(MAIL_CONFIGURATION, configureApplication.setAccountMail(mailConfig));
        configureApplication.saveConfigurationFile(FIND_FLATS_CONFIGURATION, configureApplication.setFindFlats(city, priceFrom, priceTo, howFromRooms, howToRooms));
    }

    public static void main(String[] args) {
    ConfigurationAppRunner configurationAppRunner = new ConfigurationAppRunner();
    configurationAppRunner.configuration();

    }
}
