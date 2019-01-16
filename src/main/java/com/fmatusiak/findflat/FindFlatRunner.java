package com.fmatusiak.findflat;

import java.util.ArrayList;

public class FindFlatRunner {
    public static void main(String[] args) {
        GeneratorUrl generatorUrl = new GeneratorUrl();
        String url = generatorUrl.getUrlSitePortel("Elblag","50000","150000","1","4");
        ParseHtml parseHtml = new ParseHtml();
        ArrayList<String> portel = parseHtml.parseHtmlForPortel(url);

        for(String name : portel){
            System.out.println(name);
        }
    }
}
