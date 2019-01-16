package com.fmatusiak.findflat;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class File {

    private PrintWriter printWriter;

    public File(String fileName) throws FileNotFoundException {
        printWriter = new PrintWriter(fileName);
    }

    public boolean addTextToFile(String text) {
        printWriter.println(text);
        printWriter.close();
        return true;
    }

}
