package day1_generics.smartwarehousesystem;
 public abstract class WarehouseItem {
     public String getName() {
         return name;
     }

     private String name;

     public double getPrice() {
         return price;
     }

     private double price;
     public WarehouseItem(String name , double price){
         this.name = name;
         this.price = price;

     }
     public String toString(){
         return name + "$" + price;
     }

}
