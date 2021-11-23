package com.sandeep.leetcode.personal.easy;

import java.util.*;
import java.util.stream.Collector;

public class ArraysLeetCodeEasyAntDavid {

    public static void main(String[] args) {
        int[] prices = { 1,2,3,4,5 };
        System.out.println("Maximum Profit :"+maxProfit(prices));
        int [] nums = {1,1,2 ,2,4,6,8, 8,12,15} ;
        Arrays.sort(nums);
        System.out.println("Duplicates Removed :"+removeDuplicates(nums));
        int [] rotate = { 1,2,3,4,5,6,7 } ;
        int k = 3 ;
        rotate(rotate , k);
        int[] numss = {4,1,2,1,2};
        System.out.println(""+singleNumber(numss));
        int[] nums3 = {4,1};
        System.out.println(intersect(numss,nums));
        System.out.println(plusOne(nums3));
        int[] moveZeroes = {0,0,2,1,2};
        moveZeroes(moveZeroes);
        System.out.println(twoSum(moveZeroes,3));
        int[][] rorateImage = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotate(rorateImage);
    }
    //best time to sell stocks
    private static int maxProfit(int[] prices) {
        //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
        int maxProfit = 0;
        int len = prices.length;
        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    private static int removeDuplicates(int[] nums) {
        //https://leetcode.com/problems/remove-duplicates-from-sorted-array/
        int len = nums.length;
        if (len <= 1) return len;
        int tail = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[tail++] = nums[i];
            }
        }
        return tail;
    }

    static void reverse(int a[], int n)
    {
        int i, k, t;
        for (i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }

        // printing the reversed array
        System.out.println("Reversed array is: \n");
        for (k = 0; k < n; k++) {
            System.out.println(a[k]);
        }
    }

    private static void rotate(int[] nums, int k) {
        //https://leetcode.com/problems/rotate-array/
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }

    private static void reverse(int[] nums, int from, int to) {
        while (from < to) {
            int temp = nums[from];
            nums[from++] = nums[to];
            nums[to--] = temp;
        }
    }
    //https://leetcode.com/problems/single-number/
    private static int singleNumber(int[] nums) {
        int n = 0;
        for (int num : nums) {
            n ^= num;
        }
        return n;
    }

    //https://leetcode.com/problems/intersection-of-two-arrays-ii/
    private static int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<Integer>();

        for (int num : nums1) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (int num : nums2) {
            if (map.containsKey(num)) {
                if (map.get(num) > 0) {
                    list.add(num);
                    map.put(num, map.get(num) - 1);
                }
            }
        }

        int size = list.size();
        int result[] = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = list.get(i);
        }

        return result;
    }
    //https://leetcode.com/problems/plus-one/
    private static int[] plusOne(int[] digits) {
        //Input: digits = [1,2,3]
        //Output: [1,2,4]
        int carry = 1;
        int len = digits.length;

        for (int i = len - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
            if (carry == 0) {
                break;
            }
        }

        if (carry > 0) {
            int[] result = new int[len + 1];
            result[0] = carry;
            return result;
        } else {
            return digits;
        }
    }

    private static void moveZeroes(int[] nums) {
        //nums = [0, 1, 0, 3, 12]
        // output [1, 3, 12, 0, 0]
        int len = nums.length;
        if (len < 2) return;

        int k = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }

        for(; k < len; k++) {
            nums[k] = 0;
        }
    }
    private static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int[] result = new int[2];
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }

        return null;
    }

    private static boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }

        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxs = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int k = (i / 3) * 3 + j / 3;
                    int number = board[i][j] - '0' - 1;
                    if (rows[i][number] || cols[j][number] || boxs[k][number]) {
                        return false;
                    }
                    rows[i][number] = cols[j][number] = boxs[k][number] = true;
                }
            }
        }

        return true;
    }

    private static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i ++) {
            for (int j = i; j < n - 1 - i; j ++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 -j][i];
                matrix[n - 1 -j][i] = matrix[n - 1 -i][n - 1 -j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 -i];
                matrix[j][n - 1 -i] = temp;
            }
        }
    }
}
