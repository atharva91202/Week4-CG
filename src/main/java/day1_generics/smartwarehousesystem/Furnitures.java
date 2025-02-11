package day1_generics.smartwarehousesystem;

public class Furnitures extends WarehouseItem {
    private String Material;
    public Furnitures(String name , double price , String Material){
        super(name,price);
        this.Material=Material;
    }

    public String getMaterial() {
        return Material;
    }

    @Override
    public String toString() {
        return "Furnitures : " + super.toString() + "[Material :" + Material +"]";
    }
}
