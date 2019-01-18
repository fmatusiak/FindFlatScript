package com.fmatusiak.findflat.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class File {

    public boolean addArrayTextToFile(String fileName, ArrayList<String> urlList) throws FileNotFoundException {
        fileName+=".txt";
        PrintWriter printWriter = new PrintWriter(fileName);

        for(String url : urlList){
            printWriter.println(url);
        }
        printWriter.close();

        return true;
    }

    public ArrayList readConfigurationfile(String fileName) {
        List<String> listConfiguration = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            listConfiguration = stream
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return (ArrayList) listConfiguration;
    }

}
