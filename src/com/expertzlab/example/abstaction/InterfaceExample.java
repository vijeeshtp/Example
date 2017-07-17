package com.expertzlab.example.abstaction;

/**
 * Created by vijeesh on 17/07/17.
 */
public class InterfaceExample {

    public static void main(String... args) {
        Alto alto = new Alto();
        Swift swift = new Swift();

        Person person1 = new Person();
        person1.driveCar(alto);
        person1.driveCar(swift);
    }
}

class Person {
    int age ;
    String name;

    void speak(){
    }

    void driveCar(Car car) {
        car.start();
        car.changeGear();
        car.stear();
        car.applyBreak();
    }
}

interface Car {
    void start();

    void applyBreak();

    void stear();

    void changeGear();
}




/*
abstract class Maruthi implements Car {
    public void applyBreak() {
        System.out.println("Maruthi break");
    }

    ;

  //  public abstract void stear();

    //public abstract void changeGear();

}
*/

class Alto implements Car {

    public void start (){
        System.out.println("Alto started");
    }

    public void applyBreak() {
        System.out.println(" Alto breaking...");
    }

    public void stear() {
        System.out.println(" Alto Stearing...");

    }

    public void changeGear() {
        System.out.println(" Alto gear chnageing...");
    }
}

class Swift implements Car {


    public void start (){
        System.out.println("Swift started");
    }

    public void applyBreak() {
        System.out.println(" Swift breaking...");
    }

    public void stear() {
        System.out.println(" Swift Stearing...");

    }

    public void changeGear() {
        System.out.println(" Swift gear chnageing...");
    }

}



/*
abstract class Car {
    abstract void applyBreak();
    abstract  void stear();
    abstract void changeGear();
}
*/


