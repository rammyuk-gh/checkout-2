package org.example.helper;

public class Helper {

    public static String formatToPoundsAndPennies(int totalCount) {
        return "£" + String.format("%.2f", totalCount / 100.0);
    }

}
