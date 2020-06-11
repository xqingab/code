import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 10; i++) {
            Runnable runnable=   new Runnable(){
                @Override
                public void run() {
                    try {//获取信号灯
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程"+Thread.currentThread().getName()
                            +"进入，当前已有"+(3-semaphore.availablePermits())+"个线程并发");  //可使用信号灯
                    try {
                        Thread.sleep((long)Math.random()*50000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程"+Thread.currentThread().getName()+"即将离开");
                    semaphore.release();
                }
            };
            service.execute(runnable);
        }
    }
}
