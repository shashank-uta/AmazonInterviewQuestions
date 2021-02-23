import java.util.Arrays;

public class SortArrayInDescending {
    public static void main(String[] args) {
        int[] arr = {23, 45, 11, 9, 56, 100};
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] sortArray(int[] arr) {
        int len = arr.length;
        int small, pos, i, j, temp;
        for( i=0; i<=len-1;i++){
            for(j = i; j< len; j++){
                temp = 0;
                /**
                 * here we need to switch the if statement
                 * */
                if(arr[j] > arr[i]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
