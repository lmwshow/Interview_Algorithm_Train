package alibaba;

/**
 * @Auther: minGW
 * @Date: 2018/7/24 18:43
 * @Description:
 */
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 线程池交替打印 {
    private static int n = 10;//设置交替打印次数
    private static volatile int nextPrintWho = 1;//下次打印目标，保证可见性
    private static ReentrantLock lock = new ReentrantLock();//ABC三个线程交替打印并唤醒下一个目标线程
    private static final Condition conditionA = lock.newCondition();
    private static final Condition conditionB = lock.newCondition();
    private static final Condition conditionC = lock.newCondition();


    public static void main(String[] args) {

        int[] a = new int[]{3,2,1};
        Arrays.sort(a);
        Thread threadA = new Thread() {


            @Override
            public void run() {
                try {
                    lock.lock();
                    while(nextPrintWho != 1) {
                        conditionA.await();
                    }
                    System.out.print("A");
                    nextPrintWho = 2;
                    conditionB.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        };
        Thread threadB = new Thread() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while(nextPrintWho != 2) {
                        conditionB.await();
                    }

                    System.out.print("B");

                    nextPrintWho = 3;
                    conditionC.signalAll();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        };
        Thread threadC = new Thread() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while(nextPrintWho != 3) {
                        conditionC.await();
                    }
                    System.out.print("C");
                    this.sleep(1000);//C线程打印后等待sleep一秒钟，唤醒A线程
                    nextPrintWho = 1;
                    conditionA.signalAll();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        };
//        for(int i=0; i<n; i++) {
        new Thread(threadA).start();
        new Thread(threadB).start();
        new Thread(threadC).start();
//        }
    }

}
