package com.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;


public class AmazonSortCenter {

    static PairInt selectPackages(int truckSpace, int numPackages, ArrayList<Integer> packageSpace){

        int first = 0;
        int second = 0;
        PairInt pairInt = new PairInt(first, second);
        int trucKSpaceUnits = truckSpace - 30;

        HashMap<Integer, Integer> hmap = new HashMap<>();

        for(int i=0; i<packageSpace.size(); i++){
            hmap.put(packageSpace.get(i),i);
        }
        /**
         * key  ->   Value
         * 10   ->    0
         * 35   ->    1
         * 1    ->    2
         * 40   ->    3
         * 60   ->    4
         * 25   ->    5
         * 20   ->    6
         * */

        Collections.sort(packageSpace);

        /**
         * {1, 10, 20, 25, 35, 40, 60}
         * */
        int unit1 = 0;
        int unit2 = 0;
        int start = 0;
        int end = packageSpace.size()-1;
        int max = -1;

        while( start < end){
            if(packageSpace.get(start) + packageSpace.get(end) > trucKSpaceUnits){
                end--;
            } if (packageSpace.get(start) + packageSpace.get(end) < trucKSpaceUnits){
                start++;
            } if(packageSpace.get(start) + packageSpace.get(end) == trucKSpaceUnits){
                unit1 = packageSpace.get(start);
                unit2 = packageSpace.get(end);
                first = hmap.get(unit1);
                second = hmap.get(unit2);
                max = Math.max(max, second);
                if(second >= max){
                    pairInt.setFirst(first);
                    pairInt.setSecond(second);
                    if(first > second){
                        pairInt.setFirst(second);
                        pairInt.setSecond(first);
                    }
                }
                start++;
            } else{
                first = -1;
                second = -1;
            }
        }

        return pairInt;
    }

    public static void main(String[] args) {
        ArrayList<Integer> packageSpace = new ArrayList<>(Arrays.asList(10, 35, 1, 40, 60, 25, 20));
        int truckSpace = 90;
        int numPackages = 5;

        System.out.println(AmazonSortCenter.selectPackages(truckSpace, numPackages, packageSpace));
    }

    static class PairInt {
        int first, second;

        PairInt(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }

        public void setFirst(int first) {
            this.first = first;
        }

        public int getSecond() {
            return second;
        }

        public void setSecond(int second) {
            this.second = second;
        }

        @Override
        public String toString() {
            return "com.interview.AmazonSortCenter.PairInt{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }
    }
}
