package top.mhpsy.lArray;

import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int[] arr = {2, 8, 40, 99, 123, 1, 6, 3, 7, 5, 1, 1, 1, 100, -100, 200, -23, 40};
        int temp;
//        for (int j = 0; j < arr.length; j++) {
//            for (int i = j; i < arr.length - 1; i++) {
//                if (arr[i] > arr[i + 1]) {
//                    temp = arr[i];
//                    arr[i] = arr[i + 1];
//                    arr[i + 1] = temp;
//                }
//            }
//        }
        /**
         * 下面这个写的好像还可以，我自己写的
         */
//        for (int j = arr.length; j > 0; j--) {
//            for (int i = 0; i < j - 1; i++) {
//                if (arr[i] > arr[i + 1]) {
//                    temp = arr[i];
//                    arr[i] = arr[i + 1];
//                    arr[i + 1] = temp;
//                }
//            }
//        }
        /**
         * 大概就是每一个循环数字都要循环
         */
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }


        System.out.println(Arrays.toString(arr));
    }

}
