package com.sandeep.leetcode.exercise.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class MultiplicationExceptSelf {

    public static void main(String[] args) {
        printProductExceptSelf();
    }

    private static void printProductExceptSelf() {
        int[] nums = { 3, 6, 9, 1, 3};

        int product = 1;
        for(int i=0; i< nums.length ; i++) {
            product = product * nums[i];

        }
        System.out.println("The product  is :"+product);
        Integer[] result = new Integer[nums.length];
        for(int i=0; i< nums.length ; i++) {
            result[i] = product/nums[i];
        }
        System.out.println(Arrays.stream(result).collect(Collectors.toList()));
    }

}
