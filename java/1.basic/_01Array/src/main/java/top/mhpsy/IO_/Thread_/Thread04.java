package top.mhpsy.IO_.Thread_;

public class Thread04 {
    public static void main(String[] args) {
        Thread t4 = new Thread(new T4(), "T4");
        t4.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t4.interrupt();

    }
}

class T4 implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("我是T4 刚刚进入");
            System.out.println(Thread.currentThread().getName() + "  " + Thread.currentThread().isInterrupted());
            try {
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
                System.out.println("我是T4 休眠被打断");
            }
            System.out.println("我是T4 休眠结束");
            System.out.println(Thread.currentThread().getName() + "  " + Thread.currentThread().isInterrupted());
        }
    }
}
