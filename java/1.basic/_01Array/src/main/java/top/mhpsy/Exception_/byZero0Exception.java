package top.mhpsy.Exception_;

public class byZero0Exception {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        try {
            System.out.println(a / b);
        } catch (Exception e) {
            System.out.println("除数不能为0");
        }
        System.out.println("程序正常结束");
    }
}
