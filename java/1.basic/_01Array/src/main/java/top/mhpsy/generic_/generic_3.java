package top.mhpsy.generic_;

import java.util.Arrays;

public class generic_3 {
    public static void main(String[] args) {
        Integer[] testInt = new Integer[10];
        for (int i = 0; i < testInt.length; i++) {
            testInt[i] = i;
        }
        testGenericArray<Integer> ints = new testGenericArray<Integer>(testInt);
        System.out.println(ints);
    }
}

class testGenericArray<T> {
    private T[] t;

    public testGenericArray(T[] t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "testGenericArray{" +
                "t=" + Arrays.toString(t) +
                '}';
    }

}
