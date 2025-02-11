package day1_generics.smartwarehousesystem;

import java.util.ArrayList;
import java.util.List;

public class Storage <T extends WarehouseItem>{
    private List<T> items = new ArrayList<>();
    public void additem(T item){
        items.add(item);
    }
    public void removeitems(T item){
        items.remove(item);
    }
    public List<T> getItems(){
        return items;
    }
    public static void displayItem(List<? extends WarehouseItem> items){
        for (WarehouseItem item : items){
            System.out.println(item);
        }
    }
}
