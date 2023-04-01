package top.mhpsy.IO_.Thread_;

public class Thread01 {
    public static void main(String[] args) throws InterruptedException {

        XX xx = new XX();
        xx.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("main " + (i + 1));
            Thread.sleep(1000);
        }

    }
}

class XX extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("我是XX" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
