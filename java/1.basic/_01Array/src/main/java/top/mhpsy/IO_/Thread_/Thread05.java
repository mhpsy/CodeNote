package top.mhpsy.IO_.Thread_;

public class Thread05 {
    public static void main(String[] args) {
        Thread t5 = new Thread(new T5(), "T5");
        t5.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main " + (i + 1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (i == 5) {
                try {
                    t5.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

class T5 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("我是T5");
        }
    }
}
