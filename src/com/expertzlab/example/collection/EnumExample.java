package com.expertzlab.example.collection;

/**
 * Created by vijeesh on 17/07/17.
 */
public class EnumExample {
    enum Days {SUN (1,"Sunday")  ,MON (1,"Monday") ,TUE(2 , "Thesday");
        int day;
        String desc;

        Days(int day, String desc){
            this.day =day;
            this.desc= desc;
        }
    };

    /*

        enum Days {SUN  ,MON ,TUE};


    */


    public static final int SUN=1;
    public static final int MON=2;
    public static final int TUE=3;

    public static  void main (String ...a){

        //int x = 10;
        //int day =1;

        Days day1 = Days.SUN;
        Days day2 = Days.MON;

        for (Days day : Days.values()){
            System.out.println(day.ordinal()+"-"+ day.name()+"-"+ day.day+"-"+ day.desc);

            switch (day ){

                case SUN :  System.out.println("Holiday !!!");
                    break;

                case MON :break;

            }
        }

       /*
        switch (day){

            case 1 : System.out.println("Sun");
            case 2 : System.out.println("Mon");
            case 3 : System.out.println("Tue");
            case 4 : System.out.println("Wed");
            case 5 : System.out.println("Thu");
            case 6 : System.out.println("Fri");
            case 7 : System.out.println("Dat");
        }
        */



    }


}




