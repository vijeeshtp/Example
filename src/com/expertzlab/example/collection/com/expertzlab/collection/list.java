package com.expertzlab.example.collection.com.expertzlab.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vijeesh on 11/07/17.
 */
public class list {

    public static void main (String ...a){

        List<Item> myItems= new ArrayList();
        myItems.add(new Item("1","Rice", 10, "Kg"));
        myItems.add(new Item("2","Milk", 2, "Pkt"));
        myItems.add(new Item("2","Milk", 2, "Pkt"));
        myItems.add(new Item("2","Curd", 2, "Pkt"));


        for (Item item :myItems){
            //System.out.println(item.getName() +"-"+ item.getId());
            System.out.println(item);
        }
    }

}

class Item {

    private String id ;
    private String name;
    private int qty;
    private String unit;

    public Item(String id, String name, int qty, String unit) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.unit=unit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Item{" +
              "id='" + id + '\'' +
              ", name='" + name + '\'' +
              ", qty=" + qty +
              ", unit='" + unit + '\'' +
              '}';
    }
}
