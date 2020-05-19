package my_thread;

/**
 *
 *
 * 基于一个锁和一个状态变量实现连续打印abcabc...
 * Created by mengyue on 2019/3/7.
 */
public class StateThreadPrintABC {

    private static volatile int state = 0;

    public static void main(String[] args) {

        Object lock = new Object();

        int state1 = 0;

        int state2 = 1;

        int state3 = 2;

        Thread t1 = new Thread(new PrintClass(lock, state1, state2, "A"));

        Thread t2 = new Thread(new PrintClass(lock, state2, state3, "B"));

        Thread t3 = new Thread(new PrintClass(lock, state3, state1, "C"));

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

        private Object lock;

        private int thisState;

        private int nextState;

        private String string;

        public PrintClass(Object lock, int thisState, int nextState, String string) {
            this.lock = lock;
            this.nextState = nextState;
            this.thisState = thisState;
            this.string = string;
        }

        @Override
        public void run() {

            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    while (state != thisState) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(string);

                    state = nextState;

                    //注意要notifyall，不然会死锁，因为notify只通知一个，
                    //但是同时等待的是两个,如果唤醒的不是正确那个就会没人唤醒，死锁了
                    /**
                     * 关于上面的解释
                     * 假设现在A执行完成了,全局state标志设置成了1(意思就是接下来B才能执行),然后notify了C线程
                     * C线程醒来后发现 state标志和自己的对不上,然后就进入了wait等待阶段,并没有去执行notify,
                     * 那么在wait区等待的线程B也就永远没有人去唤醒它了
                     *
                     */
                    lock.notifyAll();
                }
            }

        }
    }
}
