package com.fmatusiak.findflat;

import java.util.ArrayList;

public class FindFlatRunner {
    public static void main(String[] args) {

        GeneratorUrl generatorUrl = new GeneratorUrl();
        String url = generatorUrl.getUrlSitePortel("Gdansk", "50000", "150000", "1", "4");
        ParseHtml parseHtml = new ParseHtml();
        Result result = new Result();
        ArrayList<String> portel = parseHtml.getFlatUrlForPortel(url);
        result.showFlatsUrlInConsole(portel);


    }
}
