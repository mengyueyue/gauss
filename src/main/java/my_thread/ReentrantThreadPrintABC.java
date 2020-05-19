package my_thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by mengyue on 2019/3/7.
 */
public class ReentrantThreadPrintABC {


    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();

        Condition a = lock.newCondition();

        Condition b = lock.newCondition();

        Condition c = lock.newCondition();


        Thread t1 = new Thread(
                new PrintClass(lock, a, c, "A")
        );

        Thread t2 = new Thread(
                new PrintClass(lock, b, a, "B")

        );

        Thread t3 = new Thread(
                new PrintClass(lock, c, b, "C")
        );


        try {
            t1.start();
            Thread.sleep(100);
            t2.start();
            Thread.sleep(100);
            t3.start();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    static class PrintClass implements Runnable {


        private Condition thisCondition;

        private Condition preCondition;

        private ReentrantLock lock;

        private String str;

        public PrintClass(ReentrantLock lock, Condition thisCondition, Condition preCondition, String s) {

            this.thisCondition = thisCondition;

            this.preCondition = preCondition;

            this.lock = lock;

            this.str = s;

        }


        @Override
        public void run() {

            for (int i = 0; i < 10; i++) {
                lock.lock();

                System.out.println(str);

                thisCondition.signal();

                try {
                    preCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }
    }
}
