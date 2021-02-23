package com.interview;

import java.util.HashSet;
import java.util.Set;

public class TwoDArrays {


    public static boolean checkPairSumExists(int rows, int col, int[][] arr, int sum){
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<rows;i++){
            for(int j=0;j<col;j++){
                if(set.contains(sum - arr[i][j])){ ;
                    return true;
                }  /**
                 here in place of sum we will add arr[i][j]
                 */

                else {
                    set.add(arr[i][j]);
                }
            }
        }
            return false;
    }
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3},
                         {1, 2, 3}
        };

        System.out.println(checkPairSumExists(2, 2, array, 4));
    }
}
