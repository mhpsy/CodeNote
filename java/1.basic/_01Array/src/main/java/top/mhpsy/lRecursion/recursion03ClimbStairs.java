package top.mhpsy.lRecursion;

/**
 * 爬楼梯问题 leetCode70
 */
public class recursion03ClimbStairs {
    public static void main(String[] args) {

    }
}

class ClimbStairs {

    //f(x)=f(x−1)+f(x−2)
    public int exercise(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return exercise(n - 1) + exercise(n + 2);
    }

}
