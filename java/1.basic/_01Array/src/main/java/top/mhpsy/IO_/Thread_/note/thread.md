# Thread线程

## 1. 线程的创建

```java
public class Thread_ {
    public static void main(String[] args) {
        // 创建线程
        MyThread myThread = new MyThread();
        // 启动线程
        myThread.start();
        // 主线程
        for (int i = 0; i < 100; i++) {
            System.out.println("main: " + i);
        }
    }
}
```

```java
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("MyThread: " + i);
        }
    }
}
```

## 2. 线程的状态

1. 新建状态（New）
2. 就绪状态（Runnable）
3. 运行状态（Running）
4. 阻塞状态（Blocked）
5. 死亡状态（Dead）
6. 等待状态（Waiting）
7. 超时等待状态（Timed Waiting）

## 3. 线程的优先级

1. MAX_PRIORITY = 10
2. MIN_PRIORITY = 1
3. NORM_PRIORITY = 5
4. 优先级高的线程获取的CPU时间片多，但是不一定先执行完

## 4. 线程的同步

1. 同步代码块
2. 同步方法
3. 同步锁














