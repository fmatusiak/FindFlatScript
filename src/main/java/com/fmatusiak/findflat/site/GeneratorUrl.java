package com.fmatusiak.findflat.site;

public class GeneratorUrl {

    public String getUrlSitePortel(String city, String priceFrom, String priceTo, String howRoomsFrom, String howRoomsTo) {
        return "https://www.portel.pl/ogloszenia/nieruchomosci/lokale-mieszkalne"
                + "?z=1539010520402&zaa=1&id_katn=18&id_kat=11&rodzaj=1&cmin="
                + priceFrom + "&cmax=" + priceTo
                + "&lok=+1&imin=" + howRoomsFrom + "&imax=" + howRoomsTo;
    }

    public String getUrlSiteOlx(String city, String priceFrom, String priceTo, String howRoomsFrom, String howRooms) {
        return "https://www.olx.pl/nieruchomosci/mieszkania/sprzedaz/" + city + "/"
                + "?search[filter_float_price%3Afrom]=" + priceFrom + "&search[filter_float_price%3Ato]=" + priceTo
                + "&search[filter_enum_rooms][0]=" + howRooms;
    }

}
