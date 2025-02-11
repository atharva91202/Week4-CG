package day1_generics.smartwarehousesystem;

public class WarehouseApp {
    public static void main(String[] args) {
        //Storage for different items
        Storage<electronicItem> electronicItemStorage = new Storage<>();

        //Adding items
        Storage<groceries> groceriesStorage = new Storage<>();
        Storage<Furnitures> furnituresStorage = new Storage<>();

        electronicItemStorage.additem(new electronicItem("Laptop",120000,"Asus"));
        electronicItemStorage.additem(new electronicItem("Mobile" , 200000 ,"Motorola"));

        groceriesStorage.additem(new groceries("Milk", 2.5, "2025-01-01"));
        groceriesStorage.additem(new groceries("Bread", 1.5, "2024-12-15"));

        furnituresStorage.additem(new Furnitures("Sofa", 500, "Leather"));
        furnituresStorage.additem(new Furnitures("Table", 150, "Wood"));

        // Display all stored items using wildcard method
        System.out.println("\n--- Electronics ---");
        Storage.displayItem(electronicItemStorage.getItems());

        System.out.println("\n--- Groceries ---");
        Storage.displayItem(groceriesStorage.getItems());

        System.out.println("\n--- Furniture ---");
        Storage.displayItem(furnituresStorage.getItems());
    }
}
