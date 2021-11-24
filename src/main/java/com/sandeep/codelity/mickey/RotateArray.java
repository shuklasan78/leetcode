package com.sandeep.codelity.mickey;

import java.util.Arrays;
import java.util.stream.Collectors;

//cyclick rotation.
public class RotateArray {

    public static void main(String[] args) {
        int[] arr = {3,4,7,4,8,1};
        int[] arr2 = solution(arr,2);
        System.out.println(""+Arrays.stream(arr2).boxed().collect(Collectors.toList()));
    }

    private static int[] solution(int[] A, int K) {
        // write your code in Java SE 8

        // Using the concept of "mod" (to make it cyclic)

        int[] new_array = new int[A.length]; // a new array

        for(int i=0; i< A.length; i++){
            int new_position = (i + K) % A.length; // using "mod" to do Cyclic Rotation
            new_array[new_position] = A[i]; // put A[i] to the new position
        }

        return new_array; // return new array
    }
}
