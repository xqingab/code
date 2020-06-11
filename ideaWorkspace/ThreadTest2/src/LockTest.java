import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {


    public static void main(String[] args) {
       new LockTest().init();
    }

    private void init(){
        final   Outputer outputer = new Outputer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outputer.output("xuqing");
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outputer.output("Lilei");
                }
            }
        }).start();
    }

   static class Outputer {
        Lock lock = new ReentrantLock();
        public void output(String name){
            int len = name.length();
           // synchronized (Outputer.class){
            lock.lock();
            try {
                for (int i = 0;i<len;i++){
                    System.out.print(name.charAt(i));
                }
            }finally {
                lock.unlock();
            }


            System.out.println();

        }
        public synchronized void output2(String name){
            int len = name.length();
                for (int i = 0;i<len;i++){
                    System.out.print(name.charAt(i));
                }
            System.out.println();
        }
        public static synchronized void output3(String name){
            int len = name.length();
            for (int i = 0;i<len;i++){
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }
    }
}
