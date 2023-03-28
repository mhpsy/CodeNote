package top.mhpsy.IO_.Thread_;

public class Thread08 {
    public static void main(String[] args) {
        T8 t81 = new T8();
        t81.setFlag(true);
        T8 t82 = new T8();
        t82.setFlag(false);
        Thread thread1 = new Thread(t81, "T81");
        Thread thread2 = new Thread(t82, "T82");
        thread1.start();
        thread2.start();

    }
}

class T8 implements Runnable {
    private boolean flag = true;
    static final Object o1 = new Object();
    static final Object o2 = new Object();

    @Override
    public void run() {
        if (flag) {
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + "  " + Thread.currentThread().isInterrupted());
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + "  " + Thread.currentThread().isInterrupted());
                }
            }
        } else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + "  " + Thread.currentThread().isInterrupted());
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + "  " + Thread.currentThread().isInterrupted());
                }
            }
        }
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
