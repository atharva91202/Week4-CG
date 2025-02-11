package day1_generics.dynamiconlinemarket;

public class Product<T> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public String toString(){
        return  "Name : " + name +
                "/nPrice : " + price +
                "/nCategory" + category;

    }
}