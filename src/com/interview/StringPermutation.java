package com.interview;

import java.util.*;

public class StringPermutation {

    public void permute(char[] input) {

        Map<Character, Integer> countMap = new HashMap<>();

        for (char ch : input) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }

        char[] str = new char[countMap.size()];
        int[] count = new int[countMap.size()];
        int index = 0;

        for(Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            str[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        System.out.println(str);
        System.out.println(countMap);
        // {A=2, B=1, C=1}
        // index = {2,1,1}
        // str = {A, B, C}
        char[] result = new char[input.length];
        permuteUtil(str,count,result,0);
    }

    private void permuteUtil(char[] str, int[] count, char[] result, int level) {
        if(level == result.length){
            printArray(result);
            return;
        }

        for(int i=0; i< str.length; i++){
            if(count[i] == 0){
                continue;
            }
            result[level] = str[i];
            count[i]--;
            permuteUtil(str,count,result,level+1);
            count[i]++;
        }

    }

    private void printArray(char[] input) {
        for(char ch: input){
            System.out.println(ch);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StringPermutation sp = new StringPermutation();
        sp.permute("ABC".toCharArray());

    }
}

