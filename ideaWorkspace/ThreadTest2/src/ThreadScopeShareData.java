import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ThreadScopeShareData {
    private static int data = 0;
    private static Map<Thread,Integer> threadData = new HashMap<Thread,Integer>();
    private static ThreadLocal<Integer> x = new ThreadLocal<Integer>();
    private static ThreadLocal<MyScopeThreadData> myScopeThreadData = new ThreadLocal<MyScopeThreadData>();
    public static void main(String[] args) {
        for (int i = 0; i <2 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                  int  data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName()
                            +" has put data" + data);
                 //   threadData.put(Thread.currentThread(),data);
                //    x.set(data);
//                    MyScopeThreadData myData = new MyScopeThreadData();
//                    myData.setName("name:"+data);
//                    myData.setAge(data);
//                    myScopeThreadData.set(myData);
                    MyScopeThreadData.getThreadInstance().setName("name:"+data);
                    MyScopeThreadData.getThreadInstance().setAge(data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }

    static  class A {
        public void get(){
            //int data = threadData.get(Thread.currentThread());
           // int data =x.get();
     /*       MyScopeThreadData myData =  myScopeThreadData.get();
            System.out.println("A from "+ Thread.currentThread().getName() + " get data :" + myData.getName() +
                ","  +  myData.getAge());*/
            MyScopeThreadData myData =  MyScopeThreadData.getThreadInstance();
            System.out.println("A from "+ Thread.currentThread().getName() + " get data :" + myData.getName() +
                    ","  +  myData.getAge());
        }
    }
    static  class B {
        public void get(){
           // int data = threadData.get(Thread.currentThread());
          //  int data =x.get();
     /*       MyScopeThreadData myData =  myScopeThreadData.get();
            System.out.println("B from "+ Thread.currentThread().getName() +" get data :" + myData.getName() +
                    ","  +  myData.getAge());*/
            MyScopeThreadData myData =  MyScopeThreadData.getThreadInstance();
            System.out.println("B from "+ Thread.currentThread().getName() + " get data :" + myData.getName() +
                    ","  +  myData.getAge());
        }
    }

    static class MyScopeThreadData{
        private String name ;
        private int age;

        public static MyScopeThreadData getThreadInstance(){
            MyScopeThreadData instance = map.get();
            if (instance == null){
                instance = new MyScopeThreadData();
                map.set(instance);
            }
            return instance;
        }

        private static ThreadLocal<MyScopeThreadData> map = new ThreadLocal<MyScopeThreadData>();
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
