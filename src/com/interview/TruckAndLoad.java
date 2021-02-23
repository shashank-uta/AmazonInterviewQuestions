package com.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TruckAndLoad {
    static ArrayList<Integer> IDsOfPackages(int truckSpace, ArrayList<Integer> packagesSpace) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        truckSpace -= 30;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < packagesSpace.size();i++) {
            int val = packagesSpace.get(i);
            if(map.containsKey(truckSpace-val)) {
                int cMax = val > truckSpace-val ? val : truckSpace-val;
                if(cMax > max) {
                    max = cMax;
                    list = new ArrayList<>();
                    list.add(map.get(truckSpace-val));
                    list.add(i);
                }
            }
            map.putIfAbsent(val,i);
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> packageSpace = new ArrayList<>(Arrays.asList(10, 35, 1, 40, 60, 25, 20));
        int truckSpace = 90;
        int numPackages = 5;

        System.out.println(TruckAndLoad.IDsOfPackages(truckSpace, packageSpace));

    }
}
