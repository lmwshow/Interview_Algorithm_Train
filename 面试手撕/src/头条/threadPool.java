package 头条;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: minGW
 * @Date: 2018/9/7 10:07
 * @Description:
 */
public class threadPool {

    static class MyRunnable implements Runnable{


        @Override
        public void run() {
            for (int x = 0 ; x < 100 ; x++)
                System.out.println(Thread.currentThread().getName() + ":" + x);
        }
    }

    public static void main(String[] args){

        // 创建一个线程池对象，控制要创建几个线程对象
        ExecutorService pool = Executors.newFixedThreadPool(2);

        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());

        pool.shutdown();

    }
}
