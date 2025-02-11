package day1_generics.dynamiconlinemarket;
public class Gadgets{
    private String brand;
    private String type;

    public Gadgets(String brand, String type) {
        this.brand = brand;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Brand : " + brand + ",\nType : " + type;
    }
}
