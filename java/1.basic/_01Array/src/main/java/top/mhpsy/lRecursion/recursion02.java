package top.mhpsy.lRecursion;

public class recursion02 {

    public static void main(String[] args) {
        RecursionTest01 recursionTest01 = new RecursionTest01();
        System.out.println(recursionTest01.exercise(7));
    }

}

class RecursionTest01 {
    public int exercise(int num) {
        if (num == 1 || num == 2) {
            return 1;
        } else {
            //斐波那契数1,1,2,3,5,8,13....
            //除了第一个和第二个数之外都是等于前两个数的和也就是exercise(num-1)+exercise(num-2)
            return exercise(num - 1) + exercise(num - 2);
        }
    }

}
