package top.mhpsy.Thread_;

public class Thread02 {
    public static void main(String[] args) {
        new Thread(new ticket(), "窗口1").start();
        new Thread(new ticket(), "窗口2").start();
        new Thread(new ticket(), "窗口3").start();
    }
}

class ticket implements Runnable {
    private static int ticket = 100;

    @Override
    public void run() {

        while (true) {
            if (ticket <= 0) {
                System.out.println("票卖完了");
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "卖出了第" + ticket + "张票");
            ticket--;
        }
    }
}
