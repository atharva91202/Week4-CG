package day1_generics.smartwarehousesystem;

public class groceries extends WarehouseItem{
    private String expiryDate;
    public groceries(String name,double price,String expiryDate){
        super(name,price);
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "Groceries: " + super.toString() + "[Expiry :" + expiryDate + "]";
    }
}
