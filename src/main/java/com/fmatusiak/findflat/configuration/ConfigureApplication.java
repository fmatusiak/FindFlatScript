package com.fmatusiak.findflat.configuration;

import com.fmatusiak.findflat.mail.MailConfig;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ConfigureApplication {

    public ArrayList setAccountMail(MailConfig mailConfig) {
        ArrayList<String> mailConfigList = new ArrayList<>();
        mailConfigList.add(mailConfig.getUsername());
        mailConfigList.add(mailConfig.getPassword());
        return mailConfigList;
    }

    public ArrayList setFindFlats(String websiteName, String city, String priceFrom,
                                  String priceTo, String howFromRooms, String howToRooms) {
        ArrayList<String> flatsConfigList = new ArrayList<>();
        flatsConfigList.add(websiteName);
        flatsConfigList.add(city);
        flatsConfigList.add(priceFrom);
        flatsConfigList.add(priceTo);
        flatsConfigList.add(howFromRooms);
        flatsConfigList.add(howToRooms);
        return flatsConfigList;
    }

    public boolean saveConfigurationFile(String fileName, ArrayList<String> configurationList) {
        PrintWriter printWriter = null;

        try {
            printWriter = new PrintWriter(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Error create configuration file");
        }

        for (String configName : configurationList) {
            printWriter.println(configName);
        }
        printWriter.close();
        return true;
    }

}
