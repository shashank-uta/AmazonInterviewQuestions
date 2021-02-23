package com.interview;

public class CountTripletSumPermutation {

    public static int countTripletSumPermutations(int size, int[] arr, int tripletSum){
        // This variable contains the total
        // count of triplets found
        int count = 0 ;

        // Loop from the first to the third
        //last integer in the list
        for(int i = 0 ; i < size - 2; i++)
        {
            // Check if arr[i] is a factor
            // of target or not. If not,
            // skip to the next element
            if (tripletSum % arr[i] == 0)
            {
                /**
                 * here the index of j will start from i+1 in place of 0
                 * */
                for (int j = i + 1 ; j < size - 1; j++)
                {
                    // Check if the pair (arr[i], arr[j])
                    // can be a part of triplet whose
                    // product is equal to the target
                    if (tripletSum % (arr[i] * arr[j]) == 0)
                    {
                        // Find the remaining
                        // element of the triplet
                        int value = tripletSum / (arr[i] * arr[j]);

                        for(int k = j + 1 ; k < size ; k++ )
                        {
                            // If element is found. increment
                            // the total count of the triplets
                            if (arr[k] == value)
                            {
                                count++ ;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args)
    {
        // The target value for which
        // we have to find the solution
        int target = 93 ;

        int[] arr = {1, 31, 3, 1, 93, 3, 31, 1, 93};
        int length = arr.length;

        System.out.println(countTripletSumPermutations(length, arr, target));

    }
}
