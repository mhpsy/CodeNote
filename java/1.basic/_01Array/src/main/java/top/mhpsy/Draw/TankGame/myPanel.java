package top.mhpsy.Draw.TankGame;

import javax.swing.*;
import java.awt.*;

public class myPanel extends JPanel {
    Hero hero = null;

    public myPanel() {
        hero = new Hero(100, 100);
    }

    public static void main(String[] args) {
        myPanel myPanel = new myPanel();
        JFrame jFrame = new JFrame();

        Hero hero = new Hero(100, 100);

        jFrame.add(myPanel);
        jFrame.setSize(1000, 750);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawTank(hero.getX(), hero.getY(), g, 0, 0);
        drawTank(hero.getX() + 100, hero.getY() + 100, g, 0, 1);
        drawTank(hero.getX() + 200, hero.getY() + 100, g, 1, 1);
        drawTank(hero.getX() + 300, hero.getY() + 100, g, 2, 1);
        drawTank(hero.getX() + 400, hero.getY() + 100, g, 3, 1);

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
                g.fill3DRect(x, y, 5, 30, false);// 画出坦克左边轮子
                g.fill3DRect(x + 15, y, 5, 30, false);// 画出坦克右边轮子
                g.fill3DRect(x + 5, y + 5, 10, 20, false);// 画出坦克中间矩形
                g.fillOval(x + 5, y + 10, 10, 10);// 画出坦克中间圆形
                g.drawLine(x + 10, y + 15, x + 10, y);// 画出坦克中间线条
            }
            case 1 -> {
                g.fill3DRect(x, y, 30, 5, false);// 画出坦克左边轮子
                g.fill3DRect(x, y + 15, 30, 5, false);// 画出坦克右边轮子
                g.fill3DRect(x + 5, y + 5, 20, 10, false);// 画出坦克中间矩形
                g.fillOval(x + 10, y + 5, 10, 10);// 画出坦克中间圆形
                g.drawLine(x + 15, y + 10, x + 30, y + 10);// 画出坦克中间线条
            }
            case 2 -> {
                g.fill3DRect(x, y, 5, 30, false);// 画出坦克左边轮子
                g.fill3DRect(x + 15, y, 5, 30, false);// 画出坦克右边轮子
                g.fill3DRect(x + 5, y + 5, 10, 20, false);// 画出坦克中间矩形
                g.fillOval(x + 5, y + 10, 10, 10);// 画出坦克中间圆形
                g.drawLine(x + 10, y + 15, x + 10, y + 30);// 画出坦克中间线条
            }
            case 3 -> {
                g.fill3DRect(x, y, 30, 5, false);// 画出坦克左边轮子
                g.fill3DRect(x, y + 15, 30, 5, false);// 画出坦克右边轮子
                g.fill3DRect(x + 5, y + 5, 20, 10, false);// 画出坦克中间矩形
                g.fillOval(x + 10, y + 5, 10, 10);// 画出坦克中间圆形
                g.drawLine(x + 15, y + 10, x, y + 10);// 画出坦克中间线条
            }
        }

    }


}
