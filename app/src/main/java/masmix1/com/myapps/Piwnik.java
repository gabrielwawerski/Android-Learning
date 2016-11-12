package masmix1.com.myapps;

import java.util.ArrayList;
import java.util.List;

public class Piwnik {

    List<String> getBrand(String beerType) {
        List<String> brand = new ArrayList<>();

        switch (beerType) {
            case "zwykłe": {
                brand.add("Perła");
                brand.add("Lech");
                brand.add("Żywiec");
                brand.add("Żubr");
                brand.add("Tatra");
                brand.add("Warka");
                brand.add("Tyskie");
                return brand;
            }

            case "smakowe": {
                brand.add("Redd's");
                brand.add("Perła Summer");
                brand.add("Lech Diesel");
                brand.add("Warka Radler");
                brand.add("Lech Shandy");
                return brand;
            }

            case "mocne": {
                brand.add("Perła Mocna");
                brand.add("Okocim Mocne");
                brand.add("Mocny Full");
                brand.add("Tatra Mocne");
                brand.add("Dębowe Mocne");
                return brand;
            }
            default: {
                brand.add("Błąd!");
                return brand;
            }
        }
    }
}
//    List<String> getBrand(String beerType) {
//        List<String> brand = new ArrayList<>();
//
//        if (beerType.equals("zwykłe")) {
//            brand.add("Perła");
//            brand.add("Lech");
//            brand.add("Żywiec");
//            brand.add("Żubr");
//            brand.add("Tatra");
//            brand.add("Warka");
//            brand.add("Tyskie");
//        }
//
//        else if (beerType.equals("smakowe")) {
//            brand.add("Redd's");
//            brand.add("Perła Summer");
//            brand.add("Lech Diesel");
//            brand.add("Warka Radler");
//            brand.add("Lech Shandy");
//        }
//
//        else if (beerType.equals("mocne")) {
//            brand.add("Perła Mocna");
//            brand.add("Okocim Mocne");
//            brand.add("Mocny Full");
//            brand.add("Tatra Mocne");
//            brand.add("Dębowe Mocne");
//        }
//        return brand;
//    }