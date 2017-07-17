package com.expertzlab.example.collection;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by vijeesh on 10/07/17.
 */
public class TreeSetExample {

    public static void main (String ...a){

        Set<String> set = new TreeSet<>();
        set.add("XXXX");
        set.add("AAAA");
        set.add("BBBB");
        set.add("BBBB");
        set.add("DDDD");
        set.add("CCCC");
        set.add("Some Test");

        //You can not see any deplicate. Aslo the output is SORTED
        //printElements(set);


        Set<Customer> customers = new TreeSet<>();

        customers.add(new Customer(111,"AAAAA"));
        customers.add(new Customer(111,"AAAAA"));
        customers.add(new Customer(222,"XXXXX"));
        customers.add(new Customer(333,"BBBBB"));



        //See no deplicate.Objects are sorted based on Comparable implementation.
        //See the output after commenting equals() and hashcode() and compareTo() method of Customer class
        //Set uses hashcode and equals method of the object to identify the duplicate
        //And it is required to implement  Comparable interface
        //If not provided , it uses what is there in the Object class
        System.out.println(customers);
    }



    static void printElements(Set<String> set){
        for  (String str: set){
            System.out.println(str);
        }
    }

}


class Customer implements Comparable<Customer>  {

    int id;
    String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
              "id=" + id +
              ", name='" + name + '\'' +
              '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (id != customer.id) return false;
        return name.equals(customer.name);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        return result;
    }


    @Override
    public int compareTo(Customer o) {
        return this.name.compareTo(o.name);
    }
}