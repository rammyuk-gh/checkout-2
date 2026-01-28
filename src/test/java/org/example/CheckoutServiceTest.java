package org.example;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class CheckoutServiceTest {

    private final CheckoutService checkout = new CheckoutService();

    @Test
    void calculatesItems() {
        int total = checkout.calculateTotal(List.of("Apple", "Apple", "Orange", "Apple"));
        assertEquals(205, total);
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

}