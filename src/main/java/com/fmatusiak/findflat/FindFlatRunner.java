package com.fmatusiak.findflat;

import com.fmatusiak.findflat.file.File;
import com.fmatusiak.findflat.mail.MailConfig;
import com.fmatusiak.findflat.mail.MailSend;
import com.fmatusiak.findflat.result.Result;
import com.fmatusiak.findflat.site.GeneratorUrl;
import com.fmatusiak.findflat.site.ParseHtml;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class FindFlatRunner {
    private static final String MAIL_CONFIGURATION = "mailConfig";
    private static final String FIND_FLATS_CONFIGURATION = "flatsConfig";

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File();
        ArrayList<String> readConfigurationMail = file.readConfigurationfile(MAIL_CONFIGURATION);
        ArrayList<String> readConfigurationFlats = file.readConfigurationfile(FIND_FLATS_CONFIGURATION);

        GeneratorUrl generatorUrl = new GeneratorUrl();

        String url = generatorUrl.getUrlSitePortel(readConfigurationFlats.get(0), readConfigurationFlats.get(1),
                readConfigurationFlats.get(2), readConfigurationFlats.get(3), readConfigurationFlats.get(4));

        ParseHtml parseHtml = new ParseHtml();

        Result result = new Result();

        file.addArrayTextToFile("portel.txt", parseHtml.getFlatsUrl(readConfigurationMail.get(2), url));

        MailConfig mailConfig = new MailConfig(readConfigurationMail.get(0), readConfigurationMail.get(1), readConfigurationMail.get(2));

        MailSend mailSend = new MailSend(mailConfig);
        mailSend.sendResultsUrlToMail("portel.txt");
    }
}