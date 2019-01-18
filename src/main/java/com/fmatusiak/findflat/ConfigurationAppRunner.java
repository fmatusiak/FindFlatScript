package com.fmatusiak.findflat;

import com.fmatusiak.findflat.configuration.ConfigureApplication;
import com.fmatusiak.findflat.mail.MailConfig;

import java.util.Scanner;

public class ConfigurationAppRunner {
    private static final String MAIL_CONFIGURATION = "mailConfig";
    private static final String FIND_FLATS_CONFIGURATION = "flatsConfig";

    public static void main(String[] args) {
        ConfigurationAppRunner configurationAppRunner = new ConfigurationAppRunner();
        configurationAppRunner.configuration();
    }

    private void configuration() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("<------- Configuration Script FindFlats -------> ");
        System.out.println("------------------------------------------------");
        System.out.println("-----------------EMAIL CONFIGURATION------------");

        System.out.print("Email adress: ");
        String emailAddress = scanner.next();

        System.out.print("Email password: ");
        String emailPassword = scanner.next();

        System.out.println("------------------------------------------------");
        System.out.println("-----------------FLATS CONFIGURATION------------");
        System.out.println("------------------------------------------------");

        System.out.print("Choose website (portel or olx) : ");
        String websiteName = scanner.next();

        System.out.print("City: ");
        String city = scanner.next();

        System.out.print("Price from: ");
        String priceFrom = scanner.next();

        System.out.print("Price to: ");
        String priceTo = scanner.next();

        System.out.print("How rooms from: ");
        String howFromRooms = scanner.next();

        System.out.print("How rooms to: ");
        String howToRooms = scanner.next();

        System.out.println("Ok , it's all . Run Application FindFlats");
        System.out.println("-------------------------------------------");

        MailConfig mailConfig = new MailConfig(emailAddress, emailPassword);

        ConfigureApplication configureApplication = new ConfigureApplication();
        configureApplication.setAccountMail(mailConfig);

        configureApplication.saveConfigurationFile(MAIL_CONFIGURATION,
                configureApplication.setAccountMail(mailConfig));
        configureApplication.saveConfigurationFile(FIND_FLATS_CONFIGURATION,
                configureApplication.setFindFlats(websiteName, city, priceFrom, priceTo, howFromRooms, howToRooms));
    }
}
