package com.expertzlab.example.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vijeesh on 17/07/17.
 */
public class GenericsExample2 {

    public static void main(String... a) {

        Box<Apple> appleBox = new Box();
        Apple apple = new Apple("RoyalGala");
        appleBox.put(apple);

        Box<Orange> orangeBox = new Box();
        Orange orange = new Orange();
        orangeBox.put(orange);

        Box<Fruit> fruitBox = new Box();
        fruitBox.put(new Apple("RoyalGala"));
        fruitBox.put(new Orange());

        List<Integer> list = new ArrayList();
        list.add(new Integer(10));
        list.add(new Integer(10));
    }

    void test() {

        List<Integer> list = new ArrayList();
        list.add(new Integer(10));
        //list.add(new Apple(""));

        // List<Integer> list1 = new ArrayList<Integer>();
    }
}

/**
 * @param <T1>
 */
class Box<T1> {

    T1 type;

    public T1 get() {
        return type;
    }

    public void put(T1 type) {
        this.type = type;
    }
}

class Apple extends Fruit {

    String type;

    public Apple(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

class Orange extends Fruit {

}

class Fruit {

}


