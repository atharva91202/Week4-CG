package day1_generics.smartwarehousesystem;

public class electronicItem extends WarehouseItem{
 private String brandName;
 public electronicItem(String name , double price , String brandName){
     super(name,price);
     this.brandName = brandName;
 }

    public String getBrandName() {
        return brandName;
    }

    @Override
    public String toString() {
        return "Electronics : " + super.toString() + "[Brand : " + brandName + "]";
    }
}
