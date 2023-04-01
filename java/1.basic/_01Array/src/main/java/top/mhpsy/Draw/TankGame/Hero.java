package top.mhpsy.Draw.TankGame;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Hero extends Tank {
    Shot shot = null;

    public Hero(int x, int y) {
        super(x, y);
    }

    public Hero(int x, int y, int direct) {
        super(x, y, direct);
    }

    public void shotEnemy() {
        // 产生一颗子弹的方法
        switch (this.getDirect()) {
            // 0:up, 1:right, 2:down, 3:left
            //根据坦克的方向来产生子弹并且新建一个线程 .start()
            case 0 -> shot = new Shot(this.getX() + 20, this.getY(), 0);
            case 1 -> shot = new Shot(this.getX() + 60, this.getY() + 20, 1);
            case 2 -> shot = new Shot(this.getX() + 20, this.getY() + 60, 2);
            case 3 -> shot = new Shot(this.getX(), this.getY() + 20, 3);
        }
        Thread t = new Thread(shot);
        t.start();
    }


}
