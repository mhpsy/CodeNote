package top.mhpsy.lRecursion;

public class recursion01 {

    public static void main(String[] args) {
        RecursionTest recursionTest = new RecursionTest();
        recursionTest.print(5);
        System.out.println(recursionTest.factorial(5));
        System.out.println(2 * 3 * 4 * 5);
    }

}

class RecursionTest {
    public void print(int n) {
        if (n > 1) {
            print(n - 1);
        }
        System.out.println("n=" + n);
    }

    public int factorial(int num) {
        if (num == 1) {
            return 1;
        } else {
            return factorial(num - 1) * num;
        }
    }

}
