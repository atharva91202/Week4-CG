package mapinterface.shoppingcart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {
    private ShoppingCart shoppingCart;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        shoppingCart = new ShoppingCart();
        System.setOut(new PrintStream(outputStream)); // Redirect System.out to capture output

        // Adding products
        shoppingCart.addProduct("Laptop", 1000.00);
        shoppingCart.addProduct("Phone", 500.00);
        shoppingCart.addProduct("Tablet", 300.00);

        // Adding items to cart
        shoppingCart.addToCart("Laptop", 1);
        shoppingCart.addToCart("Phone", 2);
        shoppingCart.addToCart("Tablet", 1);
    }

    @Test
    void testDisplayCart() {
        shoppingCart.displayCart();
        String output = outputStream.toString().trim();
        assertTrue(output.contains("Laptop - Quantity: 1 - Price: $1000.0"));
        assertTrue(output.contains("Phone - Quantity: 2 - Price: $500.0"));
        assertTrue(output.contains("Tablet - Quantity: 1 - Price: $300.0"));
    }

    @Test
    void testDisplaySortedByPrice() {
        shoppingCart.displaySortedByPrice();
        String output = outputStream.toString().trim();
        assertTrue(output.contains("Tablet - $300.0"));
        assertTrue(output.contains("Phone - $500.0"));
        assertTrue(output.contains("Laptop - $1000.0"));
    }

    @Test
    void testAddNonExistingProductToCart() {
        shoppingCart.addToCart("Headphones", 1);
        String output = outputStream.toString().trim();
        assertTrue(output.contains("Product not found: Headphones"));
    }
}
