package top.mhpsy.Draw.TankGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class myPanel extends JPanel implements KeyListener, Runnable {
    Hero hero = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemySize = 3;

    int clientWidth = 800;
    int clientHeight = 500;

    public myPanel() {
        // 初始化自己的坦克
        hero = new Hero(100, 100, 0);
        hero.setSpeed(10);
        // 初始化子弹的失效范围
        Shot.clientHeight = clientHeight;
        Shot.clientWidth = clientWidth;

        // 初始化敌人的坦克
        for (int i = 0; i < enemySize; i++) {
            enemyTanks.add(new EnemyTank((i + 1) * 100, 0, 2));
        }
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
//        drawTank(hero.getX(), hero.getY(), g, 0, 0);
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);

        // 画出子弹
        if (hero.shot != null && hero.shot.isLive()) {
//            System.out.println("子弹的坐标为：" + hero.shot.getX() + "," + hero.shot.getY());
            g.setColor(Color.red);
            g.fill3DRect(hero.shot.getX(), hero.shot.getY(), 1, 1, false);
        }

        for (EnemyTank enemyTank : enemyTanks) {// 画出敌人坦克
            drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);
        }
    }

    /**
     * 画出坦克
     *
     * @param x      x坐标
     * @param y      y坐标
     * @param g      画笔
     * @param direct 方向
     * @param type   类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
            case 0 -> g.setColor(Color.cyan);
            case 1 -> g.setColor(Color.yellow);
        }

        switch (direct) {// 0:上 1:右 2:下 3:左
            case 0 -> {
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
            }
            case 1 -> {
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
            }
            case 2 -> {
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
            }
            case 3 -> {
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x, y + 20);
            }
        }

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            hero.setDirect(0);
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hero.setDirect(1);
            hero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            hero.setDirect(2);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            hero.setDirect(3);
            hero.moveLeft();
        }

        //按下空格键，发射子弹
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            System.out.println(hero.getX() + " " + hero.getY());
            hero.shotEnemy();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
    }
}
