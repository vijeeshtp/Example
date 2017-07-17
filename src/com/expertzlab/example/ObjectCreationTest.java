package com.expertzlab.example;

/**
 * Created by vijeesh on 17/07/17.
 */
public class ObjectCreationTest {public static void main (String args []){

    Cat c1 = new Cat();
    c1.legs=4;
    c1.name = "AAA";
    //c1.cry();

    System.out.println(Animal.MAX_LEGS);
    //Animal.MAX_LEGS= Animal.MAX_LEGS+10;
    System.out.println(Animal.MAX_LEGS);


    Animal.test();
    Animal a1 = new Cat( "BBBB",1);
    //a1.cry();

    Animal a2 = new Dog();
    //a2.cry();


    //new ObjectTest().makeCry(a1);

    makeCry(a1);
    makeCry(a2);
}


    static void makeCry (Animal animal){
        animal.cry();
    }

}


class  Animal{

    static final  int MAX_LEGS=10;

    String name;
    int legs;

    Animal (String name){

    }

    static void test (){
        //
    }


    Animal (){

    }

    void cry (){

        int  a= 10;
        a= a+ 10;
        System.out.println("Animal Cries");
    }

}

class Dog extends Animal {
    void cry (){
        System.out.println("Bow Bow!!!!");
    }

    Dog (){

    }

    Dog(String name){
        super(name);
    }

}

final class Cat extends Animal {

    Cat() {

    }

    Cat(String name) {
        super(name);
    }

    Cat(String name, int legs) {
        this(name);
        //this.name= name;

        if (legs < MAX_LEGS) {
            this.legs = legs;
        }

    }

    void cry() {
        System.out.println(" Mewwwww");
    }
}
