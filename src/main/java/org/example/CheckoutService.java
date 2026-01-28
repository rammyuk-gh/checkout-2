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

            return items.stream()
                    .map(item -> PRICE_MAP.getOrDefault(item, 0))
                    .reduce(0, Integer::sum);
        }

}
