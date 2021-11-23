package com.sandeep.codelity.zronchy; /**
 * The Fibonacci sequence is defined using the following recursive formula:
 *     F(0) = 0
 *     F(1) = 1
 *     F(M) = F(M - 1) + F(M - 2) if M >= 2
 * A small frog wants to get to the other side of a river. The frog is initially located at one bank of the river (position −1) and wants to get to the other bank (position N). The frog can jump over any distance F(K), where F(K) is the K-th Fibonacci number. Luckily, there are many leaves on the river, and the frog can jump between the leaves, but only in the direction of the bank at position N.
 * The leaves on the river are represented in a zero-indexed array A consisting of N integers. Consecutive elements of array A represent consecutive positions from 0 to N − 1 on the river. Array A contains only 0s and/or 1s:
 * 0 represents a position without a leaf;
 * 1 represents a position containing a leaf.
 * The goal is to count the minimum number of jumps in which the frog can get to the other side of the river (from position −1 to position N). The frog can jump between positions −1 and N (the banks of the river) and every position containing a leaf.
 * For example, consider array A such that:
 *     A[0] = 0
 *     A[1] = 0
 *     A[2] = 0
 *     A[3] = 1
 *     A[4] = 1
 *     A[5] = 0
 *     A[6] = 1
 *     A[7] = 0
 *     A[8] = 0
 *     A[9] = 0
 *     A[10] = 0
 * The frog can make three jumps of length F(5) = 5, F(3) = 2 and F(5) = 5.
 * Write a function:
 * class Solution { public int solution(int[] A); }
 * that, given a zero-indexed array A consisting of N integers, returns the minimum number of jumps by which the frog can get to the other side of the river. If the frog cannot reach the other side of the river, the function should return −1.
 * For example, given:
 *     A[0] = 0
 *     A[1] = 0
 *     A[2] = 0
 *     A[3] = 1
 *     A[4] = 1
 *     A[5] = 0
 *     A[6] = 1
 *     A[7] = 0
 *     A[8] = 0
 *    A[9] = 0
 *    A[10] = 0
 * the function should return 3, as explained above.
 * Assume that:
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer that can have one of the following values: 0, 1.
 * Complexity:
 * expected worst-case time complexity is O(N*log(N));
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 * Elements of input arrays can be modified.
 */
 
import java.util.*;
class FibFrog {
    class Jump {
        int position;
        int counter;
        Jump(int position, int counter) {
            this.position = position;
            this.counter = counter;
        }
    }
    
    public int solution(int[] A) {
        List<Integer> fibs = getFibonaci(A.length);
        boolean[] accessed = new boolean[A.length]; 
        List<Jump> jumps = new ArrayList<Jump>();
        jumps.add(new Jump(-1, 0));
        Jump cj = null;
        int step = 0;
        while(true) {
            if(step==jumps.size()) {
                return -1;
            }
            cj = jumps.get(step);
            step++;
            for(int f: fibs) {
                if(cj.position+f==A.length) {
                    return cj.counter+1;
                } else if(cj.position+f>A.length || A[cj.position+f]==0 || accessed[cj.position+f]) {
                    continue;
                }
                
                jumps.add(new Jump(cj.position+f, cj.counter+1));
                accessed[cj.position+f] = true;
            }
        }
    }
    
    public List<Integer> getFibonaci(int max) {
        List<Integer> fibs = new ArrayList<Integer>();
        fibs.add(1);
        fibs.add(1);
        int f = 1;
        while(fibs.get(f)<=max) {
            fibs.add(fibs.get(f)+fibs.get(f-1));
            f++;
        }
        fibs.remove(0);
        Collections.reverse(fibs);
        return fibs;
    }
}
/*Score: 100%*/