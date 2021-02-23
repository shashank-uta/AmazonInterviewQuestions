package com.interview;

public class ReverseAlphabetCharacters {

    public static String reverseAlphabetCharacters(String string){

        char[] inputChar = string.toCharArray();
        int right = inputChar.length-1;
        int left = 0;
        while (left < right){
            if(!Character.isAlphabetic(inputChar[left])){
                left++;
            } else if(!Character.isAlphabetic(inputChar[right])){
                right--;
            }
            /**
             * In the else statement left++ and right-- should be done, not outside of it
             * */
            else {
                char temp = inputChar[left];
                inputChar[left] = inputChar[right];
                inputChar[right] = temp;
                left++;
                right--;
            }
        }
        return new String(inputChar);
    }

    public static void main(String[] args) {
        String inputString = "<a-b+c=e^f>g<h";
        System.out.println("Input String Before reversing: " +inputString);
        System.out.println("Input String After Reversing Characters: " + reverseAlphabetCharacters(inputString));
    }
}

