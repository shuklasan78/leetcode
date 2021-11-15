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
        int target = 18;
        Map<Integer, Integer> myMap = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();
        for( int i =0 ; i< nums.length ;i++) {
            int complement = target - nums[i];
            if(myMap.containsKey(complement)) {
                System.out.println(myMap.get(complement)+"   "+i);
                //store the value in array
                int[] arr = {myMap.get(complement),i};
                return arr;
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
