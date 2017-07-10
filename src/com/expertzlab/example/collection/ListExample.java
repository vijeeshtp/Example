package com.expertzlab.example.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * Created by vijeesh on 10/07/17.
 */
public class ListExample {

    public static void main (String ...arg){

        //List created with out generics
        //Any type of object is allowed to add to the list
        List list = new ArrayList();

        //Below is some other implementations for lists
        //List list = new LinkedList();
        //List list = new Vector();

        list.add (new String ("AAAAA"));
        list.add (new String ("BBBBB"));
        list.add (new String ("CCCCC"));
        list.add (new Integer(10));
        list.add(2, new String("DDDDD"));


        //Below is a generic list.
        //It allows only the type  mentioned in the < > to be added to the list
        List<String> list1 = new ArrayList<>();
        list1.add (new String ("Test1"));
        list1.add (new String ("Test2"));
        list1.add (new String ("Test3"));
        //Since the below line try to add another type of object in the list
        //The below line result in compile time error.
        //list1.add (new Integer(10));

        printElements(list);

        removeElements(list);

        printElements(list);

        printElementsWithForEach(list);

        printElementsWithForEach(list);
    }

    static void printElements(List list){
        Iterator itr1 = list.iterator();
        while (itr1.hasNext()){
            System.out.println(itr1.next());
        }
    }


    static void printElementsWithForEach(List list){
        for  (Object obj: list){
            System.out.println(obj);
            //Since we are not using generics we need to cast
            //This can cause runtime issues  if list contains some objects other than String
            System.out.println(((String) obj).length());

        }
    }

    static void printElementsWithGeneric(List<String> list){
        for  (String str: list){
            System.out.println(str);
            System.out.println(str.length());
        }
    }


    /**
     *
     *
     * @param list
     */
    static void removeElements (List list){
        Iterator itr2 = list.iterator();
        while (itr2.hasNext()){
            Object obj = itr2.next();
            //Put what elements to be removed from the list
            if (obj instanceof Integer){
                itr2.remove();
            }
        }
    }
}
