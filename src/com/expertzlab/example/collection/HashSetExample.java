package com.expertzlab.example.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by vijeesh on 10/07/17.
 */
public class HashSetExample {

    public static void main (String ...a){

        Set<String> set = new HashSet<>();
        set.add("AAAA");
        set.add("AAAA");
        set.add("BBBB");
        set.add("BBBB");
        set.add("CCCC");
        set.add("CCCC");
        set.add("Some Test");

        //You can not see any deplicate.
        printElements(set);

        Set<Student> students = new HashSet<>();
        students.add(new Student(111,"AAA"));
        students.add(new Student(111,"AAA"));
        students.add(new Student(222,"BBB"));
        students.add(new Student(222,"BBB"));

        //See no deplicate.
        //See the output after commenting equals() and hashcode() method of Student class
        //Set uses hashcode and equals method of the object to identify the duplicate
        //If not provided , it uses what is there in the Object class
        System.out.println(students);
    }



    static void printElements(Set<String> set){
        for  (String str: set){
            System.out.println(str);
        }
    }




}


class Student {

    int rollno;
    String name;

    public Student(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
              "rollno=" + rollno +
              ", name='" + name + '\'' +
              '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (rollno != student.rollno) return false;
        return name.equals(student.name);

    }

    @Override
    public int hashCode() {
        int result = rollno;
        result = 31 * result + name.hashCode();
        return result;
    }

}