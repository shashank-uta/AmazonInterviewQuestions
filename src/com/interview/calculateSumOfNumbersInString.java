package com.interview;

import java.util.Scanner;

public class calculateSumOfNumbersInString {
    public static int calculateSumOfNumbersInString(String inputString){
        String temp = "";
        int sum = 0;
        for(int i = 0; i < inputString.length(); i++) {
            char ch = inputString.charAt(i);
            if(Character.isDigit(ch))
                temp += ch;
            /**
             * sum and temp should be inside the else statement
             * */
            else{
                sum += Integer.parseInt(temp);
                temp = "0";
            }
        }
        return sum + Integer.parseInt(temp);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the input String: \n");
        String str = scanner.nextLine();
        System.out.println(calculateSumOfNumbersInString(str));
    }
}
