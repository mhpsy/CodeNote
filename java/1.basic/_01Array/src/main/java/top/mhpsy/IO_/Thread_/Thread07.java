package top.mhpsy.IO_.Thread_;

public class Thread07 {
    public static void main(String[] args) {
        Thread t7 = new Thread(new T7(), "T7");
        t7.setDaemon(true);//设置为守护线程
        t7.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("main " + (i + 1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class T7 implements Runnable {
    @Override
    public void run() {
        for (; ; ) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("我是T7");
        }
    }
}
