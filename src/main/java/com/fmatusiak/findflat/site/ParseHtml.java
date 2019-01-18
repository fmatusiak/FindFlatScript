package com.fmatusiak.findflat.site;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class ParseHtml {

    public ArrayList<String> getFlatsUrl(String fromPortalName, String url) {
        ArrayList<String> flatUrlList = new ArrayList<>();
        Document doc = null;

        try {
            doc = (Document) Jsoup.connect(url).get();
        } catch (IOException e) {
            System.out.println("Error in read website:  " + url);
        }

        if (fromPortalName.equals("portel")) {
            Elements newsHeadlines = doc.select("div#category");
            Elements tmpHeadlines = newsHeadlines.select("div.list.plat");
            Elements Property = tmpHeadlines.select("a");

            for (Element headline : Property) {
                flatUrlList.add(headline.attr("href"));
            }

        } else {
            Elements newsHeadlines = doc.select("tr.wrap");
            Elements Property = newsHeadlines.select("a");

            for (Element headline : Property) {
                flatUrlList.add(headline.attr("href"));
            }
        }
        return flatUrlList;
    }

}
