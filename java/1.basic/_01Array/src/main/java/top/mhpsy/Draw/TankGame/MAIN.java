package top.mhpsy.Draw.TankGame;

import javax.swing.*;
import java.awt.*;

public class MAIN {
    public static void main(String[] args) {
        new MAIN();
    }

    public MAIN() {
        myPanel myPanel = new myPanel();
        new Thread(myPanel).start();
        //设置黑色背景
        myPanel.setBackground(Color.BLACK);
        JFrame jFrame = new JFrame();
        jFrame.add(myPanel);
        jFrame.setSize(myPanel.clientWidth, myPanel.clientHeight);
        jFrame.addKeyListener(myPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
