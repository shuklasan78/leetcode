package com.sandeep.leetcode.exercise.string;
import java.util.*;
public class LeetCodeBetterSolutions {
    public static void main(String[] args) {
        System.out.println(firstUniqChar2("lovely"));
    }

    //Source : https://leetcode.com/problems/first-unique-character-in-a-string/
    private static int firstUniqChar2(String s) {
        HashMap<Character, Integer> count = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (count.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }


}
