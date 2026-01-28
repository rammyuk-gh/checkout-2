package org.example;

import java.util.List;
import java.util.Map;

public class CheckoutService {

    private static final Map<String, Integer> PRICE_MAP = Map.of(
            "Apple", 60,
            "Orange", 25
    );

    public int calculateTotal(List<String> items) {

        if (items == null || items.isEmpty()) {
            return 0;
        }

        long appleCount = items.stream().filter("Apple"::equals).count();
        long orangeCount = items.stream().filter("Orange"::equals).count();

        int appleTotal = applyAppleOffer(appleCount);
        int orangeTotal = applyOrangeOffer(orangeCount);

        return appleTotal + orangeTotal;


    }

    private int applyAppleOffer(long count) {
        long payable = (count / 2) + (count % 2);
        return (int) payable * PRICE_MAP.get("Apple");
    }

    private int applyOrangeOffer(long count) {
        long groupsOfThree = count / 3;
        long remainder = count % 3;
        int priceForOrange = PRICE_MAP.get("Orange");
        return (int) ((groupsOfThree * 2 * priceForOrange) + (remainder * priceForOrange));
    }


}
