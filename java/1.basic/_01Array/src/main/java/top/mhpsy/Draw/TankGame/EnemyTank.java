package top.mhpsy.Draw.TankGame;

import java.util.Vector;

public class EnemyTank extends Tank {
    public Vector<Shot> shots = new Vector<>();// 敌人坦克的子弹

    public EnemyTank(int x, int y, int direct) {
        super(x, y, direct);
    }

    public EnemyTank(int x, int y) {
        super(x, y);
    }
}
