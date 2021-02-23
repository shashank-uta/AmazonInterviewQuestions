package com.interview;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {20, 30, 10, 40, 50};
        System.out.println(Arrays.toString(arr));
        reverseArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] reverseArray(int[] arr) {
        int i, temp, originallen = arr.length;
        int len = originallen;
        for(i = 0; i < originallen/2; i++){
            temp = arr[len -1];
            arr[len -1] = arr[i];
            arr[i] = temp;
            len -= 1;
            /**
             * here we need to reduce the length in place of increasing it
             * */
        }
        return arr;
    }
}
