package com.fmatusiak.findflat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class ParseHtml {

    public ArrayList<String> getFlatUrlForPortel(String url) {
        ArrayList<String> flatUrlList = new ArrayList<>();
        Document doc = null;

        try {
            doc = (Document) Jsoup.connect(url).get();
        } catch (IOException e) {
            System.out.println("Error in read website:  " + url);
        }

        Elements newsHeadlines = doc.select("div#category");
        Elements tmpHeadlines = newsHeadlines.select("div.list.plat");
        Elements Property = tmpHeadlines.select("a");

        for (Element headline : Property) {
            flatUrlList.add(". " + "https://www.portel.pl" + headline.attr("href") + "\n");
        }

        return flatUrlList;
    }

    public ArrayList<String> getFlatUrlForOlx(String url) {
        ArrayList<String> flatUrlList = new ArrayList<>();
        Document doc = null;

        try {
            doc = (Document) Jsoup.connect(url).get();
        } catch (IOException e) {
            System.out.println("Error in read website:  " + url);
        }

        Elements newsHeadlines = doc.select("tr.wrap");
        Elements tmpProperty = newsHeadlines.select("a");

        for (Element headline : tmpProperty) {
            flatUrlList.add(headline.attr("href") + "\n");
        }

        return flatUrlList;
    }


}
