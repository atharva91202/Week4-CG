package mapinterface.shoppingcart;

import java.util.*;

public class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>(); // Stores product prices
    private LinkedHashMap<String, Integer> cart = new LinkedHashMap<>(); // Maintains order of added items
    private TreeMap<Double, List<String>> sortedByPrice = new TreeMap<>(); // Stores items sorted by price

    // Add a product with its price
    public void addProduct(String product, double price) {
        productPrices.put(product, price);
    }

    // Add an item to the cart
    public void addToCart(String product, int quantity) {
        if (!productPrices.containsKey(product)) {
            System.out.println("Product not found: " + product);
            return;
        }
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }

    // Display items in the order they were added
    public void displayCart() {
        System.out.println("\nItems in Cart (Order of Addition):");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " - Quantity: " + entry.getValue() + " - Price: $" + productPrices.get(entry.getKey()));
        }
    }

    // Display items sorted by price
    public void displaySortedByPrice() {
        sortedByPrice.clear();
        for (Map.Entry<String, Double> entry : productPrices.entrySet()) {
            sortedByPrice.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }

        System.out.println("\nItems Sorted by Price:");
        for (Map.Entry<Double, List<String>> entry : sortedByPrice.entrySet()) {
            for (String product : entry.getValue()) {
                System.out.println(product + " - $" + entry.getKey());
            }
        }
    }
}