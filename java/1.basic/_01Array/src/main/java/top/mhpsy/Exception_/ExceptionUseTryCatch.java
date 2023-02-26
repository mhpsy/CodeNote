package top.mhpsy.Exception_;

import java.util.Scanner;

public class ExceptionUseTryCatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入一个整数");
            String str = scanner.nextLine();

            try {
                int num = Integer.parseInt(str);
                System.out.println("输入的整数是：" + num);
                break;
            } catch (NumberFormatException e) {
                System.out.println("输入的不是整数，请重新输入");
            }

        }
    }
}
