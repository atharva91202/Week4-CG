package day1_generics.dynamiconlinemarket;

public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();

        Product<Book> book = new Product<>("Java Fundamentals", 39.99, new Book("Programming"));
        Product<Clothing> trouser = new Product<>("Formal Trouser", 3.5, new Clothing("Formal", "30"));
        Product<Gadgets> gadget = new Product<>("Pixel 8", 1200, new Gadgets("Google", "Mobile"));

        // adding products to product catalog
        catalog.addProduct(book);
        catalog.addProduct(trouser);
        catalog.addProduct(gadget);

        // displaying list before apply discount
        System.out.println("Before Discount :-");
        catalog.displayProducts();


        // applying discount
        Catalog.applyDiscount(book, 15);
        Catalog.applyDiscount(trouser, 20);
        Catalog.applyDiscount(gadget, 10);

        // displaying list before apply discount
        System.out.println("After Discount :-");
        catalog.displayProducts();
    }
}
