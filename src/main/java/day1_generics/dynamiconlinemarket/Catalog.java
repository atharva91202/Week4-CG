package day1_generics.dynamiconlinemarket;

import java.util.*;

public class Catalog {
    private List<Product<?>> productList = new ArrayList<>();

    public void addProduct(Product<?> product){
        productList.add(product);
    }

    public List<Product<?>> getProducts(){
        return productList;
    }

    public static <T extends Product<?>> void applyDiscount(T product, double discountPercentage){
        System.out.println("Updating Price !!");
        double discount = (product.getPrice() * discountPercentage) / 100;
        product.setPrice(product.getPrice() - discount);
        System.out.println("Price Updated !!\n");
    }

    public void displayProducts(){
        for(Product<?> product : productList){
            System.out.println(product);
        }
    }
}