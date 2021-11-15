package com.sandeep.leetcode.exercise.arrays;

import java.util.*;

public class SumProblem {

    public static void main(String[] args) {
        //twoSumProblem();
        //threeSumZeroProblem();
        //twoSumZeroProblem();
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

    private static void threeSumZeroProblem() {
        //callicoder
        int[] nums = {7, 12, 3,1 ,2, -6, 5, -8, 6};
        int target = 0;
        List<Integer[]> result = new ArrayList<>();

        for( int i=0; i< nums.length ;i++) {
            for( int j = i+ 1; j< nums.length ;j++) {
                for ( int k = j+1 ; k < nums.length ;k++) {
                    if(nums[i] + nums[j] + nums[k] == target) {
                        Integer[] numArr = { nums[i] , nums[j] ,nums[k] };
                        result.add(numArr);
                    }
                }
            }
        }
        for(Integer[] intval : result) {
            System.out.println("The value is :"+ Arrays.deepToString(intval));
        }
    }
    //generic method to resolve the issue.
    private static void twoSumZeroProblem() {
        //callicoder
        int[] nums = {7, 12, 3,1 ,2, -6, 5, -8, 6};
        int target = 19;
        List<Integer[]> result = new ArrayList<>();

        for( int i=0; i< nums.length ;i++) {
            for( int j = i+ 1; j< nums.length ;j++) {
                    if(nums[i] + nums[j] == target) {
                        Integer[] numArr = { nums[i] , nums[j]  };
                        result.add(numArr);
                    }

            }
        }
        for(Integer[] intval : result) {
            System.out.println("The value is :"+ Arrays.deepToString(intval));
        }
    }
}
