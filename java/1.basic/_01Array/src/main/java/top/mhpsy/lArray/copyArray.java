package top.mhpsy.lArray;

import java.util.Arrays;

public class copyArray {
    public static void main(String[] args) {
        int[] arr1 = new int[10];
        Arrays.fill(arr1, 100);//填充满arr1，全部填充100
        for (int i : arr1) {
            System.out.println(i);
        }
        int[] arr2 = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }
        System.out.println(Arrays.stream(arr2).sum());
        System.out.println(Arrays.toString(arr2));
        System.out.println(arr1 == arr2);

    }
}
