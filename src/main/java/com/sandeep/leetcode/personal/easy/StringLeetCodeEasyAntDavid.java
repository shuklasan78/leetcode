package com.sandeep.leetcode.personal.easy;

import java.util.Arrays;

public class StringLeetCodeEasyAntDavid {

    private static void main(String[] args) {

    }

    private static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private static int reverse(int x) {
        long result = 0;
        for (; x != 0; x /= 10) {
            result = result * 10 + x % 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)result;
    }

    private static int firstUniqChar(String s) {
        int out = s.length();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            int index = s.indexOf(ch);
            if (index == -1) continue;
            if (index == s.lastIndexOf(ch)) {
                out = Math.min(out, index);
            }
        }

        return (out == s.length()) ? -1 : out;
    }

    private static boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        Arrays.sort(chs);
        Arrays.sort(cht);
        return (new String(chs)).equals(new String(cht));
    }

    private static boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            char lc = s.charAt(i);
            char rc = s.charAt(j);

            if (!isAlphaNumeric(lc)) {
                i++;
                continue;
            }

            if (!isAlphaNumeric(rc)) {
                j--;
                continue;
            }

            if (toLowerCase(lc) != toLowerCase(rc)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    private static boolean isAlphaNumeric(char c) {
        return (c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }

    private static int toLowerCase(char c) {
        return (c >= 97 && c <= 122) ? c - 32 : c;
    }

    private static int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int len = str.length();
        int i = 0;

        while (i < len && str.charAt(i) == ' ') {
            i++;
        }

        if (i >= len) {
            return 0;
        }

        char sign = str.charAt(i);
        int flag = 1;
        if (sign == '-' || sign == '+') {
            flag = (sign == '-') ? -1 : 1;
            i++;
        }

        long result = 0;
        while (i < len) {
            char c = str.charAt(i++);
            if (c < '0' || c > '9' || result > Integer.MAX_VALUE) {
                break;
            }
            result = result * 10 + c - '0';
        }

        result *= flag;
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int)result;
    }

    private static int strStr(String haystack, String needle) {
        if (null == haystack || null == needle) {
            return -1;
        }
        return haystack.indexOf(needle);
    }


    private static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private static String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        int mid = (l + r) / 2;
        String left = longestCommonPrefix(strs, l, mid);
        String right = longestCommonPrefix(strs, mid + 1, r);
        return commonPrefix(left, right);
    }

    private static String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }
}
