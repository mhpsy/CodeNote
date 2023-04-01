package top.mhpsy.IO_.Thread_;

public class Thread06 {
    public static void main(String[] args) {
        ticket2 ticket2 = new ticket2();
        Thread t1 = new Thread(ticket2, "窗口1");
        Thread t2 = new Thread(ticket2, "窗口2");
        Thread t3 = new Thread(ticket2, "窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class ticket2 implements Runnable {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (ticket <= 0) {
                    System.out.println("票卖完了");
                    break;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                ticket--;
                System.out.println(Thread.currentThread().getName() + "卖出了第" + ticket + "张票");
            }
        }
    }
}
