package top.mhpsy.Draw;

import javax.swing.*;
import java.awt.*;

public class DrawCircle extends JFrame {

    public static void main(String[] args) {
        new DrawCircle();
    }

    public DrawCircle() {
        MyPanel myPanel = new MyPanel();
        this.add(myPanel);// 添加面板
        this.setSize(400, 300);// 设置窗体大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置窗体关闭方式
        this.setVisible(true);// 设置窗体可见
    }

}

class MyPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawOval(50, 50, 30, 30);
    }
}

