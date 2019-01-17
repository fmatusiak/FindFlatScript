package com.fmatusiak.findflat.configuration;

import com.fmatusiak.findflat.mail.MailConfig;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConfigureApplication {


    public ArrayList setAccountMail(MailConfig mailConfig) {
        ArrayList<String> mailConfigList = new ArrayList<>();

        mailConfigList.add(mailConfig.getUsername());
        mailConfigList.add(mailConfig.getPassword());
        mailConfigList.add(mailConfig.getWebisteName());

        return mailConfigList;
    }

    public ArrayList setFindFlats(String city, String priceFrom, String priceTo, String howFromRooms, String howToRooms) {
        ArrayList<String> flatsConfigList = new ArrayList<>();

        flatsConfigList.add(city);
        flatsConfigList.add(priceFrom);
        flatsConfigList.add(priceTo);
        flatsConfigList.add(howFromRooms);
        flatsConfigList.add(howToRooms);

        return flatsConfigList;
    }


    public ArrayList readConfigurationfile(String fileName) {
        List<String> listConfiguration = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            listConfiguration = stream
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        listConfiguration.forEach(System.out::println);

        return (ArrayList) listConfiguration;
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
