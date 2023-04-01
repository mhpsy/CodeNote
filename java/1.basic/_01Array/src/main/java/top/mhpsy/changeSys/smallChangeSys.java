package top.mhpsy.changeSys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

public class smallChangeSys {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StringBuilder details = new StringBuilder("======================");

        double money = 0f;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        boolean loop = true;
        do {
            System.out.println("\n============================");
            System.out.println("    1.明细");
            System.out.println("    2.入账");
            System.out.println("    3.消费");
            System.out.println("    4.退出");
            System.out.println("============================");
            System.out.print("请选择(1-4): ");
            int key = scanner.nextInt();
            switch (key) {
                case 1 -> {
                    System.out.println("明细sys");
                    System.out.println(details);
                }
                case 2 -> {
                    System.out.println("收益入账金额");
                    double moneyIn = scanner.nextDouble();
                    if (moneyIn <= 0) {
                        System.out.println("输入错误");
                        break;
                    }
                    money += moneyIn;
                    System.out.println("收益入账成功");
                    details.append("\n收益入账金额\t").append(moneyIn).append("\t").append(sdf.format(new Date())).append("\t").append(money);
                }
                case 3 -> {
                    System.out.println("消费项目");
                    String item = scanner.next();
                    System.out.println("消费金额");
                    double moneyOut = scanner.nextDouble();
                    if (moneyOut <= 0 || moneyOut > money) {
                        System.out.println("输入不合法");
                        break;
                    }
                    money -= moneyOut;
                    System.out.println("消费成功");
                    details.append("\n").append(item).append("\t").append(-moneyOut).append("\t").append(sdf.format(new Date())).append("\t").append(money);
                }
                case 4 -> {
                    System.out.println("退出 bye :D ^_^");
                    loop = false;
                }
                default -> System.out.println("输入错误");
            }
        } while (loop);

    }
}
