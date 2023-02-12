package top.mhpsy.lArray;

import java.lang.reflect.Array;
import java.util.Arrays;

public class reverseArray {
    public static void main(String[] args) {
        int[] arr = new int[101];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        System.out.println(Arrays.toString(arr));

        int tempInt;
        int len = arr.length;
        for (int i = 0; i < len / 2; i++) {
            tempInt = arr[i];
            arr[i] = arr[len - i - 1];
            arr[len - i - 1] = tempInt;
        }

        System.out.println(Arrays.toString(arr));


    }
}
