package com.interview;

public class ConsecutiveVowels {

    public static boolean isBoolean(char ch){
        return (ch == 'a') || (ch == 'e') || (ch == 'i') || (ch == 'o') || (ch == 'u');
    }
    public static String removeConsecutiveVowels(String str) {
        String str1 = "";
        str1 = str1 + str.charAt(0);


        /**
         * In the for loop, in the if condition we have to change from && to ||
         * */

        for(int i=1;i<str.length();i++){
            if(!isBoolean(str.charAt(i-1)) || !isBoolean(str.charAt(i))){
                char ch = str.charAt(i);
                str1 = str1 + ch;
            }
        }
        return str1;
    }
    public static void main(String[] args) {
        String str = "aeiou";
        System.out.println(removeConsecutiveVowels(str));
    }
}
