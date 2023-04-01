package top.mhpsy.Draw.event_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyBall extends JFrame {
    MyPanel myPanel = null;

    public static void main(String[] args) {

        new MyBall();
    }

    public MyBall() {
        myPanel = new MyPanel();
        this.add(myPanel);
        this.setSize(1000, 1000);
        this.addKeyListener(myPanel);// 添加键盘监听
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}

/**
 * 监听键盘分为两步：
 * 1. panel实现KeyListener接口 class MyPanel extends JPanel implements KeyListener {
 * 2. frame添加键盘监听  this.addKeyListener(myPanel);// 添加键盘监听
 */

class MyPanel extends JPanel implements KeyListener {

    int x = 50;
    int y = 50;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawOval(x, y, 30, 30);
    }


    @Override
    public void keyTyped(KeyEvent e) {
        // 有字符输出

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // 按下键盘
//        System.out.println(e.getKeyChar());
//        System.out.println(e.getKeyCode());
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            y -= 10;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            y += 10;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x -= 10;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x += 10;
        }
        this.repaint();// 重画

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // 释放键盘(松开)

    }
}
