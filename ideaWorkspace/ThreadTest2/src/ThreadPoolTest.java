import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    public static void main(String[] args) {
   //  ExecutorService threadPool =  Executors.newFixedThreadPool(3);
//        ExecutorService threadPool =  Executors.newCachedThreadPool();
        ExecutorService threadPool =  Executors.newSingleThreadExecutor();
        for (int i = 1; i <=10 ; i++) {
            final int task = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    for (int i = 1; i <=10 ; i++) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+" is looping of "+i+" for task "+task);
                    }
                }
            });
        }
        System.out.println("all of 10 tasks have committed! ");
//        threadPool.shutdown();
    Executors.newScheduledThreadPool(3).scheduleAtFixedRate(new Runnable() {
        @Override
        public void run() {
            System.out.println("bombing");
        }
    },5,2, TimeUnit.SECONDS);
    }
}
