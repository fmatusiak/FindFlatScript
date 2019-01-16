package com.fmatusiak.findflat;

import java.util.ArrayList;

public class Result {

    public void showFlatsUrlInConsole(ArrayList<String> flatsUrlList) {
        flatsUrlList.stream().forEach(System.out::println);
    }
}
