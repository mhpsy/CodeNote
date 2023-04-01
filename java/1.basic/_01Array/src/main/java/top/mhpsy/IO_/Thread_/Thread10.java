package top.mhpsy.IO_.Thread_;

public class Thread10 {
    public static void main(String[] args) {
        boolean isDaemon = args.length != 0;
        Runnable r = () -> {
            Thread t = Thread.currentThread();//获取当前线程
            while (true) {
                System.out.printf("I am %s. Alive: %s state: %s%n", t.getName(), t.isAlive() ? "" : "not", t.getState());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t = new Thread(r, "r1");
        if (isDaemon) {
            t.setDaemon(true);
        }
        System.out.printf("%s is  %salive and in %s state%n", t.getName(), t.isAlive() ? "" : "not ", t.getState());
        Thread t1 = new Thread(r, "r2");
        if (isDaemon) {
            t1.setDaemon(true);
        }
        System.out.printf("%s is  %salive and in %s state%n", t1.getName(), t1.isAlive() ? "" : "not ", t1.getState());
        t.start();
        t1.start();
    }
}
