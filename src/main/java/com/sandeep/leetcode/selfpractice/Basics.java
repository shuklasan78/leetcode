package com.sandeep.leetcode.selfpractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Basics {


    public static void main(String[] args) {

    }


    private static void mentionGoodConcept(){
        //Converting<Integer> to int[]
        int[] nums = { 0,0,1,1,1,2,2,3,3,4 };
        nums =  Arrays.stream(nums).boxed().distinct().mapToInt(i->i).toArray();

        //convert list to array.
        List<Integer> lst = new ArrayList<>();
        int[] array = lst.stream().mapToInt(i->i).toArray();
        System.out.println("Intersection is :"+lst);


    }
}
