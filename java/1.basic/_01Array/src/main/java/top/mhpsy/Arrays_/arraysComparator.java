package top.mhpsy.Arrays_;

import java.util.Comparator;

public class arraysComparator {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 5, 6, 7, 8, 9, 0};
        bubbleSort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (int) o1 - (int) o2;
            }
        });
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

    public static void bubbleSort(int[] arr, Comparator comparator) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (comparator.compare(arr[j], arr[j + 1]) > 0) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
