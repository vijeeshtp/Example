package interthread;

/**
 * Created by vijeesh on 19/07/17.
 */
public class SyncTest {

    public static void main (String ...a){

        Counter counter = new Counter();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i < 1000; i++){
                    counter.increment();
                    try {Thread.sleep(50); } catch (Exception e){}
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i < 1000; i++){
                    counter.increment();
                    try {Thread.sleep(50); } catch (Exception e){}
                }
            }
        });


        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e){
        }
        System.out.println("TOTAL COUNT >>"+ counter.count);
     }

}





class Counter{
    int count;

   synchronized public void increment (){
        count = count + 1;
        //try {Thread.sleep(100); } catch (Exception e){}
        //System.out.println("Counter -"+ count);
    }

}