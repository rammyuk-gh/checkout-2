package org.example;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class CheckoutServiceTest {

    private final CheckoutService checkout = new CheckoutService();

    @Test
    void calculatesItems() {
        int total = checkout.calculateTotal(List.of("Apple", "Apple", "Orange", "Apple"));
        assertEquals(145, total);
    }

    @Test
    void ignoresUnknownItems() {
        int total = checkout.calculateTotal(List.of("Apple", "Banana", "Orange"));
        assertEquals(85, total);
    }

    @Test
    void emptyListReturnsZero() {
        int total = checkout.calculateTotal(List.of());
        assertEquals(0, total);
    }

    @Test
    void appliesBuyOneGetOneFreeOnApples() {
        int total = checkout.calculateTotal(List.of("Apple", "Apple"));
        assertEquals(60, total); // 2 apples → pay for 1 as buy one get one free
    }

    @Test
    void appliesThreeForTwoOnOranges() {
        int total = checkout.calculateTotal(List.of("Orange", "Orange", "Orange"));
        assertEquals(50, total); // pay for 2 as get 3rd one free
    }

    @Test
    void appliesAllOffersTogether() {
        int total = checkout.calculateTotal(List.of(
                "Apple", "Apple", "Orange", "Orange", "Orange"
        ));
        assertEquals(110, total); // apples: 60, oranges: 50
    }

}