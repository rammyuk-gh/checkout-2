package org.example;

import org.example.helper.Helper;

import java.util.List;

public class Main {

    private final static CheckoutService checkout = new CheckoutService();

    public static void main(String[] args) {
        int total = checkout.calculateTotal(List.of("Apple", "Apple", "Orange", "Apple"));
        System.out.println(Helper.formatToPoundsAndPennies(total)); // prints £1.45
    }
}