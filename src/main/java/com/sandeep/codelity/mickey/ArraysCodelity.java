package com.sandeep.codelity.mickey;

import java.util.Arrays;

public class ArraysCodelity {

    public static void main(String[] args) {

    }

    static void distinct() {
        int[] A = { 2,5,3,8,7,5};
        // special case
        if(A.length ==0) {
            // empty  artray
        }


        // initial setting: one distinct number
        int result =1;

        // Using "Arrays.sort(A)" (important)
        Arrays.sort(A);

        // for counting the distinct numbers
        for(int i=1; i < A.length; i++){
            if(A[i] != A[i-1]){ // distinct
                result++;
            }
        }
    }
}
