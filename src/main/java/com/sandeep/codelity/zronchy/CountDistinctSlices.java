package com.sandeep.codelity.zronchy;

/**
 * An integer M and a non-empty zero-indexed array A consisting of N non-negative integers are given. All integers in array A are less than or equal to M.
 * A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A. The slice consists of the elements A[P], A[P + 1], ..., A[Q]. A distinct slice is a slice consisting of only unique numbers. That is, no individual number occurs more than once in the slice.
 * For example, consider integer M = 6 and array A such that:
 *     A[0] = 3
 *     A[1] = 4
 *     A[2] = 5
 *     A[3] = 5
 *     A[4] = 2
 * There are exactly nine distinct slices: (0, 0), (0, 1), (0, 2), (1, 1), (1, 2), (2, 2), (3, 3), (3, 4) and (4, 4).
 * The goal is to calculate the number of distinct slices.
 * Write a function:
 * class Solution { public int solution(int M, int[] A); }
 * that, given an integer M and a non-empty zero-indexed array A consisting of N integers, returns the number of distinct slices.
 * If the number of distinct slices is greater than 1,000,000,000, the function should return 1,000,000,000.
 * For example, given integer M = 6 and array A such that:
 *     A[0] = 3
 *     A[1] = 4
 *     A[2] = 5
 *     A[3] = 5
 *     A[4] = 2
 * the function should return 9, as explained above.
 * Assume that:
 * N is an integer within the range [1..100,000];
 * M is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [0..M].
 * Complexity:
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(M), beyond input storage (not counting the storage required for input arguments).
 * Elements of input arrays can be modified.
 */
class CountDistinctSlices {
    public int solution(int M, int[] A) {
        // the algorithm is that for each tail the head points at the most right
        // place where there is no same element between tail and head.we know
        // that the worst case is that all the elements of the array are the
        // same, and at this circumstance the time complexity is O(2*N).
        int N = A.length;
        // the counter array for every element in the array A
        int[] counters = new int[M+1];
        int head = 0;
        int tail = 0;
        int result = 0;
        while (tail < N) {
            // find the most right end of the array for each tail
            while (head < N && counters[A[head]] != 2) {
                counters[A[head]]++;
                if (counters[A[head]] == 2)
                    break;
                head++;
            }
            result += head - tail;
            if (result > 1000000000)
                return 1000000000;
            // set the counter of the element before tail to be 0
            counters[A[tail]] = 0;
            tail++;
        }
        return result;
    }
}
/*Score: 100%*/