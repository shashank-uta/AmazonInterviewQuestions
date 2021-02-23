package com.interview;

public class CountTeams {

    static int count = 0;

    public static int countTeams(int num, int[] skills, int minAssociates, int minLevel, int maxLevel) {
        _countTeams(skills, minAssociates, minLevel, maxLevel, 0);
        return count;
    }

    private static void _countTeams(int[] skills, int minAssociates, int minLevel, int maxLevel, int currIndex) {
        if (minAssociates <= 0) {
            count++;
        }
        if (currIndex == skills.length) {
            return;
        }

        for (int i = currIndex; i < skills.length; i++) {
            if(skills[i] >= minLevel && skills[i] <= maxLevel) {
                _countTeams(skills, minAssociates - 1, minLevel, maxLevel, i+1);
            }
        }

    }

    public static void main(String[] args) {
        int num = 6;
        int[] skills = {12, 4, 6, 13, 5, 10};
        int minAssociates = 3;
        int minLevel = 4;
        int maxLevel = 10;

        /***
         * Teams that meet the criteria {4, 6, 5, 10}
         * */

        /***
         * 5 teams that can be formed are {4,5,6}, {4, 6, 10}, {4,5,10}, {5, 6, 10}, and {4, 5, 6, 10}
         * */

        System.out.println(countTeams(num, skills, minAssociates, minLevel, maxLevel));
    }
}
