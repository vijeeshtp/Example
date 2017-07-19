package interthread;

/**
 * Created by vijeesh on 18/07/17.
 */
public class InterThreadMessage {
        public static void main (String ...a){
        Queue q= new Queue();
        Consumer c= new Consumer(q);
        Producer p= new Producer(q);
        p.start();
        c.start();
    }
    }


    class Queue{

        String message ;
        boolean valueSet;

        synchronized  public  String get (){

            if (!valueSet){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("got-"+message);

            valueSet=false;
            notify();

            return message;
        }

        synchronized public void set (String message) throws InterruptedException{
            if (valueSet){
                wait();
            }

            this.message = message;
            System.out.println("setting -"+ message);

            valueSet = true;
            notify();
        }
    }


    class Consumer extends Thread {

        Queue q;

        Consumer (Queue q){
            this.q = q;
        }

        public void run (){
            while (true) {
                try {
                    sleep(500);
                //    int temp = q.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }


    class Producer extends Thread {

        Queue queue;

        int i;

        Producer(Queue q) {
            this.queue = q;
        }

        public void run() {
            while (true) {
                try {
                    //sleep() introduced to make producer slower then consumer
                    sleep(1000);
                  //  queue.set(++i);
                    //System.out.println("Producer-"+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }


