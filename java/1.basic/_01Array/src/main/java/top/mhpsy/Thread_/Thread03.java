package top.mhpsy.Thread_;

public class Thread03 {
    public static void main(String[] args) {
        Thread thread = new Thread(new interrupt_());
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread.interrupt();
    }
}

class interrupt_ implements Runnable {
    @Override
    public void run() {
        while (!Thread.interrupted()) {
            System.out.println("我是interrupt_  " +
                    Thread.currentThread().getName() + "  "
                    + Thread.currentThread().isInterrupted());
        }
    }
}