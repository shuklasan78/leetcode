package com.sandeep.codelity.zronchy; /**
 * A zero-indexed array A consisting of N integers is given. A triplet (P, Q, R) is triangular if it is possible to build a triangle with sides of lengths A[P], A[Q] and A[R]. In other words, triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:
 * A[P] + A[Q] > A[R],
 * A[Q] + A[R] > A[P],
 * A[R] + A[P] > A[Q].
 * For example, consider array A such that:
 *   A[0] = 10    A[1] = 2    A[2] = 5
 *   A[3] = 1     A[4] = 8    A[5] = 12
 * There are four triangular triplets that can be constructed from elements of this array, namely (0, 2, 4), (0, 2, 5), (0, 4, 5), and (2, 4, 5).
 * Write a function:
 * class Solution { public int solution(int[] A); }
 * that, given a zero-indexed array A consisting of N integers, returns the number of triangular triplets in this array.
 * For example, given array A such that:
 *   A[0] = 10    A[1] = 2    A[2] = 5
 *   A[3] = 1     A[4] = 8    A[5] = 12
 * the function should return 4, as explained above.
 * Assume that:
 * N is an integer within the range [0..1,000];
 * each element of array A is an integer within the range [1..1,000,000,000].
 * Complexity:
 * expected worst-case time complexity is O(N2);
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 * Elements of input arrays can be modified.
 */

import java.util.*;

class CountTriangles {
    public int solution(int[] A) {
        int N = A.length;
        Arrays.sort(A);
        int result = 0;
        for (int i=0; i < N; i++) {
            int k = i + 2;
            for (int j=i+1; j < N; j++) {
                while(k<N && A[i]+A[j]>A[k]) {
                    k++;    
                }
                result += k-j-1; 
            }
        }
        return result;
        
    }
}
/*Score: 100%*/