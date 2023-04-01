package top.mhpsy.Exception_;

import java.util.Scanner;

public class customException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入年龄");
            try {
                int age = scanner.nextInt();
                if (age < 0 || age > 120) {
                    throw new AgeException("年龄不合法");
                }
                System.out.println("年龄是：" + age);
                break;
            } catch (AgeException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("输入的不是整数，请重新输入");
            }
        }

    }
}

class AgeException extends RuntimeException {
    public AgeException() {
        super();
    }

    public AgeException(String message) {
        super(message);
    }
}
