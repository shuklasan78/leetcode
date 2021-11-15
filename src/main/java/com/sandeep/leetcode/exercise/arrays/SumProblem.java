package com.sandeep.leetcode.exercise.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumProblem {

    public static void main(String[] args) {
        twoSumProblem();
        threeSumProblem();
    }

    private static int[] twoSumProblem() {

        int[] nums = {2,7,8,11,12,21};
        int target = 33;
        Map<Integer, Integer> myMap = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();
        for( int i =0 ; i< nums.length ;i++) {
            int complement = target - nums[i];
            if(myMap.containsKey(complement)) {
                return new int[] {myMap.get(complement),i};
            } else {
                myMap.put(nums[i], i);
            }

        }
        System.out.println(myMap);
            return new int[] {} ;
    }

    private static void threeSumProblem() {

    }
}
