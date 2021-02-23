package com.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DebtRecordsNew {

    public static List<String> smallestNegativeBalance(int numRows, int numCols, List<List<String>> debts) {

        List<String> result = new ArrayList<>();

        HashMap<String, Integer> input = new HashMap<>();


        /**
         *  debts.add(Arrays.asList("Alex", "Blake", "2"));
         *  debts.add(Arrays.asList("Blake", "Alex", "2"));
         *  debts.add(Arrays.asList("Casey", "Alex", "5"));
         *  debts.add(Arrays.asList("Blake", "Casey", "7"));
         *  debts.add(Arrays.asList("Alex", "Blake", "4"));
         *  debts.add(Arrays.asList("Alex", "Casey", "4"));
         *
         */

        for (List<String> strings : debts) {

            String borrower = strings.get(0);
            String lender = strings.get(1);
            Integer amt = Integer.parseInt(strings.get(2));

            if (input.containsKey(borrower)) {
                Integer getCurrentAmt = input.get(borrower);
                getCurrentAmt -= amt;
                input.put(borrower, getCurrentAmt);
            } else {
                input.put(borrower, -1 * amt);
            }

            if (input.containsKey(lender)) {
                Integer getCurrentAmt = input.get(lender);
                getCurrentAmt = getCurrentAmt + amt;
                input.put(lender, getCurrentAmt);
            } else {
                input.put(lender, amt);
            }
        }

        TreeMap<Integer, List<String>> outputSorted = new TreeMap<>();

        for (Map.Entry entry : input.entrySet()) {

            if (!outputSorted.containsKey(entry.getValue())) {
                List<String> newList = new ArrayList<>();
                newList.add(entry.getKey().toString());
                outputSorted.put((Integer) entry.getValue(), newList);
            } else {
                List<String> getList = outputSorted.get((Integer) entry.getValue());
                getList.add(entry.getKey().toString());
                outputSorted.put((Integer) entry.getValue(), getList);
            }

        }


        System.out.println(input);
        System.out.println(outputSorted);

        for (Map.Entry entry : outputSorted.entrySet()) {
            if ((Integer) entry.getKey() < 0) {
                List<String> currrernt = (List<String>) entry.getValue();
                Collections.sort(currrernt);
                result.addAll(currrernt);
            }
        }

        if (result.isEmpty()) {
            result.add("Nobody has a negative balance");
        }
        return result;

    }

    public static void main(String[] args) {


        int numCols = 3;
        int numRows = 1;

        List<List<String>> debts = new ArrayList<>();

        debts.add(Arrays.asList("Alex", "Blake", "2"));
        debts.add(Arrays.asList("Blake", "Alex", "2"));
        debts.add(Arrays.asList("Casey", "Alex", "5"));
        debts.add(Arrays.asList("Blake", "Casey", "7"));
        debts.add(Arrays.asList("Alex", "Blake", "4"));
        debts.add(Arrays.asList("Alex", "Casey", "4"));

        //System.out.println(debts);


        /** Borrower    Lender  Amount
         * Alex         Blake       2
         * Blake        Alex        2
         * Casey        Alex        5
         * Blake        Casey       7
         * Alex         Blake       4
         * Alex         Casey       4
         * */

        /*
         * 6
         * Alex Blake 2
         * Blake Alex 2
         * Casey Alex 5
         * Blake Casey 7
         * Alex Blake 4
         * Alex Casey 4
         * */

        List<String> res = smallestNegativeBalance(numRows, numCols, debts);

        System.out.println(res);
    }
}