package com.expertzlab.example.generics;

import java.io.Closeable;
import java.io.Serializable;

/**
 * Created by vijeesh on 17/07/17.
 */
public class ThreadExample {

    public static void main (String ...ars){
        JavaTraining java = new JavaTraining();
        BigDataTraining bigData= new BigDataTraining();
        bigData.start();
        //java.training();
        //bigData.training();


        Spring spring = new Spring();
        Thread springTraining = new Thread(spring);
        springTraining.start();

        Thread javaThread = new Thread(java);
        javaThread.start();


         new Thread(new Runnable() {
            public void run() {
                for (int i =0; i< 10; i++) {
                    System.out.println("Spark Training");
                }
            }
        }).start();



        try {
            bigData.join();
            springTraining.join();
            javaThread.join();
        }catch (InterruptedException e) {
            e.getStackTrace();
        }

        System.out.println("ALL TRAINING COMPLETED!!!!");
        //SparkTraining.start();

    }



}



class Spring implements Runnable{

    public void run (){
        for (int i =0; i< 10; i++) {
            System.out.println("Spring Training");
            try{ Thread.sleep(500);} catch(InterruptedException e) {e.printStackTrace();}
        }
    }

}


class Training {


}

class JavaTraining  extends Training implements Runnable, Serializable{

    public void run (){
        for (int i =0; i< 10; i++) {
            System.out.println("Java Training");
            try{ Thread.sleep(1000);} catch(InterruptedException e) {e.printStackTrace();}
        }
    }

}

class BigDataTraining extends Thread {

    public void run() {
        for (int i =0; i< 10; i++) {
            System.out.println("BigData Training");
            try{ sleep(1000);} catch(InterruptedException e) {e.printStackTrace();}
        }
    }
}
