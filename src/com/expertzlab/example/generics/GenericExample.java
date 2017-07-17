package com.expertzlab.example.generics;


import java.util.Comparator;

/**
 * Created by vijeesh on 07/07/17.
 */
public class GenericExample {

    public static void main (String ... args){
        Pair<Integer, String> p1 = new Pair<>(1, "apple");
        Pair<Integer, String> p2 = new Pair<>(2, "pear");
        boolean same = Util.compare(p1, p2);
    }

}

/**
 *
 */
class Util {
    public static <V,K> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p2.getKey().equals(p1.getKey()) &&  p2.getValue().equals(p1.getValue());
    }
}

/**
 *
 * @param <K>
 * @param <V>
 */
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }
    public K getKey()   {
        return key;
    }
    public V getValue() {
        return value;
    }
}

