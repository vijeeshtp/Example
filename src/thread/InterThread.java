package thread;

/**
 * Created by vijeesh on 16/07/17.
 */

public class InterThread {
    public static void main (String ...a){
        Queue queue= new Queue();
        Consumer consumer= new Consumer(queue);
        Producer p= new Producer(queue);
        consumer.start();
        p.start();
    }
}


class Queue{
    int num ;
    boolean valueSet;

    synchronized  public  int get (){
        System.out.println("get-START");
        if (!valueSet){
            try {
                System.out.println("get-WAIT");
                wait();
                System.out.println("get-AFTER-WAIT");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("get-"+num);
        valueSet=false;
        return num;
    }

    synchronized public void set (int num) throws InterruptedException{
        System.out.println("set-START");
        if (valueSet){
            System.out.println("set-WAIT");
            wait();
            System.out.println("set-AFTER-WAIT");
        }

        this.num = num;
        System.out.println("set-"+num);

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
                int temp = q.get();
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
                sleep(1000);
                queue.set(++i);
                //System.out.println("Producer-"+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


