package my_thread;

/**
 * Created by mengyue on 2019/3/7.
 */
public class ThreadPrintABC {


    public static void main(String[] args) throws InterruptedException {

        //lock a
        Object a = new Object();

        //lock b
        Object b = new Object();

        //lock c
        Object c = new Object();


        Thread t1 = new Thread(new PrintClass(c, a, "A"));

        Thread t2 = new Thread(new PrintClass(a, b, "B"));

        Thread t3 = new Thread(new PrintClass(b, c, "C"));

        t1.start();
        Thread.sleep(100);
        t2.start();
        Thread.sleep(100);
        t3.start();

        t1.join();


    }


    /**
     *
     */
    static class PrintClass implements Runnable {

        private Object preLock;

        private Object thisLock;

        private String printStr;



        public PrintClass(Object preLock, Object thisLock, String s) {
            this.preLock = preLock;
            this.thisLock = thisLock;
            this.printStr = s;
        }

        @Override
        public void run() {

            int printNum = 10;

            for (int i = 0; i < printNum; i++) {
                synchronized (preLock) {

                    synchronized (thisLock) {

                        System.out.println(printStr);

//                        try {
//                            thisLock.wait();// 这样写的话 就是死锁了
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }

                        thisLock.notify();
                    }
                    //必须要加判断，不然能够打印6次 但6次后就会直接死锁
                    //这里为什么
                    if (i < printNum - 1) {
                        try {
                            preLock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }

        }
    }

}






