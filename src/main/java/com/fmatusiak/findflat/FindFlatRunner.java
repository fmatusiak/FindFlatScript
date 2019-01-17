package com.fmatusiak.findflat;

import com.fmatusiak.findflat.file.File;
import com.fmatusiak.findflat.result.Result;
import com.fmatusiak.findflat.site.GeneratorUrl;
import com.fmatusiak.findflat.site.ParseHtml;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FindFlatRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GeneratorUrl generatorUrl = new GeneratorUrl();

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

        String url = generatorUrl.getUrlSitePortel(city, priceFrom, priceTo, howFromRooms, howToRooms);

        // String url = generatorUrl.getUrlSitePortel("Elblag", "50000", "150000", "1", "4");

        ParseHtml parseHtml = new ParseHtml();

        ArrayList<String> portel = parseHtml.getFlatUrl("portel",url);

        Result result = new Result();

        System.out.println("<----------------------- RESULTS -----------------------> ");

        result.showFlatsUrlInConsole(portel);

        File file = null;

        try {
            file = new File("portel.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Error in create file");
        }

        System.out.println("Save to file ");
        file.addArrayTextToFile(portel);
    }
}
