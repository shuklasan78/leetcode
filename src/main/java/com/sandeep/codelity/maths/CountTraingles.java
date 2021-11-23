package com.sandeep.codelity.maths;

import java.util.Arrays;

public class CountTraingles {

    public static void main(String[] args) {

    }
    /*
    Given an unsorted array of positive integers, find the number of triangles that can be formed with three different array elements as three sides of triangles. For a triangle to be possible from 3 values, the sum of any of the two values (or sides) must be greater than the third value (or third side).
Examples:


Input: arr= {4, 6, 3, 7}
Output: 3
Explanation: There are three triangles
possible {3, 4, 6}, {4, 6, 7} and {3, 6, 7}.
Note that {3, 4, 7} is not a possible triangle.

Input: arr= {10, 21, 22, 100, 101, 200, 300}.
Output: 6

Explanation: There can be 6 possible triangles:
{10, 21, 22}, {21, 100, 101}, {22, 100, 101},
{10, 100, 101}, {100, 101, 200} and {101, 200, 300}
     */
    public int solution(int[] A) {

        int  numTriangle = 0;

        // important: sort the edges
        // so that we just need to check if
        // "1st edge + 2nd edge > 3rd edge"
        Arrays.sort(A);

        // Using "Caterpillar method"
        // so we can have O(n^2), not O(n^3)
        for(int i=0; i < A.length-2; i++){

            // the leftEnd and rightEnd of the "Caterpillar"
            int leftEnd = i+1;
            int rightEnd = i+2;

            while(leftEnd < A.length-1){

                // key point of "Caterpillar method"
                if(rightEnd < A.length && A[i] + A[leftEnd] > A[rightEnd]){
                    rightEnd++; // increase the Caterpillar
                }
                else{
                    // note: need to minus "1"
                    // because the rightEnd is not included
                    numTriangle = numTriangle + (rightEnd - leftEnd - 1);
                    leftEnd++; // decrease the Caterpillar
                }
            }
        }

        return numTriangle;
    }


}
