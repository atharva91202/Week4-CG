package mapinterface.shoppingcart;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Adding products with prices
        cart.addProduct("Laptop", 1000.00);
        cart.addProduct("Phone", 500.00);
        cart.addProduct("Tablet", 300.00);
        cart.addProduct("Headphones", 100.00);
        cart.addProduct("Mouse", 50.00);

        // Adding items to the cart
        cart.addToCart("Phone", 1);
        cart.addToCart("Laptop", 1);
        cart.addToCart("Mouse", 2);
        cart.addToCart("Tablet", 1);
        cart.addToCart("Headphones", 3);

        // Display cart and sorted items
        cart.displayCart();
        cart.displaySortedByPrice();
    }
}