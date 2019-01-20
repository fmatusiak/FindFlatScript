package com.fmatusiak.findflat;

import com.fmatusiak.findflat.file.File;
import com.fmatusiak.findflat.mail.MailConfig;
import com.fmatusiak.findflat.mail.MailSend;
import com.fmatusiak.findflat.site.GeneratorUrl;
import com.fmatusiak.findflat.site.ParseHtml;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class FindFlatRunner {
    private static final String MAIL_CONFIGURATION = "mailConfig";
    private static final String FIND_FLATS_CONFIGURATION = "flatsConfig";

    public static void main(String[] args) {
        FindFlatRunner findFlatRunner = new FindFlatRunner();
        findFlatRunner.run();
    }

    private void run() {
        File file = new File();
        ArrayList<String> readConfigurationMail = file.readConfigurationfile(MAIL_CONFIGURATION);
        ArrayList<String> readConfigurationFlats = file.readConfigurationfile(FIND_FLATS_CONFIGURATION);

        String websiteName = readConfigurationFlats.get(0);
        String city = readConfigurationFlats.get(1);
        String priceFrom = readConfigurationFlats.get(2);
        String priceTo = readConfigurationFlats.get(3);
        String howFromRooms = readConfigurationFlats.get(4);
        String howToRooms = readConfigurationFlats.get(5);

        String emailName = readConfigurationMail.get(0);
        String emailPassword = readConfigurationMail.get(1);

        GeneratorUrl generatorUrl = new GeneratorUrl();
        String url = generatorUrl.getUrlSitePortel(city, priceFrom, priceTo,
                howFromRooms, howToRooms);

        ParseHtml parseHtml = new ParseHtml();
        ArrayList<String> listFlat = parseHtml.getFlatsUrl(websiteName, url);

        try {
            file.addArrayTextToFile(websiteName, listFlat);
        } catch (FileNotFoundException e) {
            System.out.println("Error write to file");
        }

        MailConfig mailConfig = new MailConfig(emailName, emailPassword);
        MailSend mailSend = new MailSend(mailConfig);
        mailSend.sendResultsUrlToMail(websiteName);
    }
}