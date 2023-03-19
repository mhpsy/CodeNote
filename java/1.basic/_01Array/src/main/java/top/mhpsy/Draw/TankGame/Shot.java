package top.mhpsy.Draw.TankGame;

public class Shot implements Runnable {
    private int x;// 子弹的x坐标
    private int y;// 子弹的y坐标
    private int direct;// 子弹的方向
    private int speed = 10;// 子弹的速度
    private boolean isLive = true;// 子弹是否存活private

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    static int clientWidth = 1000;
    static int clientHeight = 750;

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    public Shot(int x, int y, int direct, int speed) {
        this.x = x;
        this.y = y;
        this.direct = direct;
        this.speed = speed;
    }

    public void move() {
        switch (direct) {
            case 0 -> y -= speed;
            case 1 -> x += speed;
            case 2 -> y += speed;
            case 3 -> x -= speed;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void run() {
        while (isLive) {
            if (x < 0 || x > clientWidth || y < 0 || y > clientHeight) {
                isLive = false;
                break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            move();
        }
    }
}
