package com.interview;

public class CountOccurence {

    public static void main(String[] args) {
        int[] arr = {1, 1, 4, 5, 6, 1};
        int value = 1;
        System.out.println(occurenceOfValue(arr, value));
    }

    private static int occurenceOfValue(int[] arr, int value) {
        int i=0, count = 0, len=arr.length;

        while(i < len){
            if(arr[i] == value){
                count++;
            }
            i++;
        }
        return count;
    }
}
