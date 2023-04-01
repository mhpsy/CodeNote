package top.mhpsy.changeSys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class smallChangeSysOOP {
    private Scanner scanner = new Scanner(System.in);

    private StringBuilder details = new StringBuilder("======================");

    private double money = 0f;

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private boolean loop = true;

    public void details() {
        System.out.println("明细sys");
        System.out.println(this.details);
    }

    public void income() {
        System.out.println("收益入账金额");
        double moneyIn = this.scanner.nextDouble();
        if (moneyIn <= 0) {
            System.out.println("输入错误");
            return;
        }
        this.money += moneyIn;
        System.out.println("收益入账成功");
        this.details.append("\n收益入账金额\t").append(moneyIn).append("\t").append(this.sdf.format(new Date())).append("\t").append(this.money);
    }

    public void consume() {
        System.out.println("消费项目");
        String item = this.scanner.next();
        System.out.println("消费金额");
        double moneyOut = this.scanner.nextDouble();
        if (moneyOut <= 0 || moneyOut > this.money) {
            System.out.println("输入不合法");
            return;
        }
        this.money -= moneyOut;
        System.out.println("消费成功");
        this.details.append("\n").append(item).append("\t").append(-moneyOut).append("\t").append(this.sdf.format(new Date())).append("\t").append(this.money);
    }

    public void exit() {
        System.out.println("退出 bye :D ^_^");
        this.loop = false;
    }

    public void menu() {
        do {
            System.out.println("\n============================");
            System.out.println("    1.明细");
            System.out.println("    2.入账");
            System.out.println("    3.消费");
            System.out.println("    4.退出");
            System.out.println("============================");
            System.out.print("请选择(1-4): ");
            int key = this.scanner.nextInt();
            switch (key) {
                case 1 -> this.details();
                case 2 -> this.income();
                case 3 -> this.consume();
                case 4 -> this.exit();
                default -> System.out.println("输入错误");
            }
        } while (this.loop);
    }


}

