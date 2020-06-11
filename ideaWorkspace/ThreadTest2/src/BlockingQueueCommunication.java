import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueCommunication {
    public static void main(String[] args) {
        final  Business business = new Business();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <=50 ; i++) {
                    business.sub(i);
                }
            }
        }).start();

        for (int i = 1; i <=50 ; i++) {
            business.main(i);
        }
    }

  static  class Business {
        private boolean bShouldSub = true ;

        BlockingQueue<Integer> quque1  = new ArrayBlockingQueue<Integer>(1);
        BlockingQueue<Integer> quque2  = new ArrayBlockingQueue<Integer>(1);
      {
          try {
              quque2.put(1);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
        public  void sub(int i) {
            try {
                quque1.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int j =1; j <=10 ; j++) {
                System.out.println("sub thread sequece"+j+",loop of"+i);
            }
            try {
                quque2.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public  void main(int i) {
            try {
                quque2.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int j = 1; j <=100 ; j++) {
                System.out.println("main thread sequece"+j+",loop of "+i);
            }
            try {
                quque1.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
