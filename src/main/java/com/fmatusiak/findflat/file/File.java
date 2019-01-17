package com.fmatusiak.findflat.file;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class File {

    private PrintWriter printWriter;

    public File(String fileName) throws FileNotFoundException {
        printWriter = new PrintWriter(fileName);
    }

    public boolean addArrayTextToFile(ArrayList<String> urlList) {

        for(String url : urlList){
            printWriter.println(url);
        }
        printWriter.close();
        return true;
    }

}
