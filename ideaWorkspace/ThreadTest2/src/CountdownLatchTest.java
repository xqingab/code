import java.util.concurrent.*;

public class CountdownLatchTest {
    public static void main(String[] args)  {
        ExecutorService service = Executors.newCachedThreadPool();
        final CountDownLatch cdOrder = new CountDownLatch(1);
        final CountDownLatch cdAndser = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("线程"+Thread.currentThread().getName()+"正准备接受命令" );
                        cdOrder.await();
                        System.out.println("线程"+Thread.currentThread().getName()+"已接受命令");
                        Thread.sleep((long)Math.random()*10000);
                        System.out.println("线程"+Thread.currentThread().getName()+"回应命令处理结果");
                        cdAndser.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            service.execute(runnable);
        }

        try {
            Thread.sleep((long)Math.random()*10000);
            System.out.println("线程"+Thread.currentThread().getName()+"即将发布命令" );
            cdOrder.countDown();
            System.out.println("线程"+Thread.currentThread().getName()+"已发送命令，正在等待结果" );
            cdAndser.await();
            System.out.println("线程"+Thread.currentThread().getName()+"已收到所有响应结果" );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }
}