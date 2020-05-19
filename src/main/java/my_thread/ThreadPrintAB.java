package my_thread;

/**
 * Created by mengyue on 2019/3/5.
 */
public class ThreadPrintAB {

    //volatile int total = 0;

    public static void main(String[] args) throws InterruptedException {

        final PrintClass pc = new PrintClass();

        Thread.currentThread().setName("mengyue_thread_test");


        Thread a = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                pc.printA();
            }
        });

        a.setName("thread A");
        a.start();


        Thread b = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                pc.printB();
            }
        });

        b.setName("thread B");
        b.start();


    }
}


class PrintClass {


    boolean flag = true;

    public synchronized void printB() {

        while (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println('b');
        flag = true;
        this.notify();
    }


    public synchronized void printA() {

        while (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println('a');
        flag = false;
        this.notify();
    }

}





