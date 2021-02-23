package com.interview;

public class CountRotationsUtil {


    public static int countRotationsUtil(int[] list, int low, int high){
        if(high < low)
            return 0;

        if(high == low)
            return low;

        int mid = low + (high - low)/2;

        if(mid < high && list[mid+1] < list[mid])
            return (mid+1);
    /**
     * In the below if statement we have to return mid in place of mid-1
     * */
        if(mid > low && list[mid] < list[mid-1])
            return mid;
     /**
      * In the below return statement the parameters that we have to pass are list, low, mid-1
      * */
        if(list[high] > list[mid])
            return countRotationsUtil(list, low, mid-1);

        return countRotationsUtil(list, mid, high);
    }

    public static void main(String[] args) {
        int[] list = {15, 18, 2, 3, 6, 12};
        int size = list.length;

        System.out.println(countRotationsUtil(list, 0 , size-1));
    }
}
