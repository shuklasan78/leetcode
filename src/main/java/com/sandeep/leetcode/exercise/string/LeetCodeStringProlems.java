package com.sandeep.leetcode.exercise.string;

import java.util.*;

public class LeetCodeStringProlems {

    public static void main(String[] args) {

        firstFive();
       // secondFive();
       // thirdFive();
    }

    private static void firstFive() {
       // System.out.println(FirstUniqueCharacterInAString("lleetcode"));
        //System.out.println(repeatedSubstringPattern("ababa"));
        //System.out.println(reverseWords("  the     sky is blue"));
        //System.out.println(myAtoi("2147483649 fgdgfd"));
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        fullJustify(words,  maxWidth);
    }
    private static void secondFive() {
        System.out.println(zigZagConvert("PAYPALISHIRING", 5));
        System.out.println(compareVersion("1.11.1", "1.11"));
        System.out.println(isPalindrome("9891 "));
        System.out.println(validPalindrome("9891"));
        System.out.println(isIsomorphic("abcd", "dear"));
    }

    private static void thirdFive() {
        char[] A = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(compress(A));
        String[] B = {"abc", "a", "adkd"};
        System.out.println(longestCommonPrefix(B));
        int result = longestPalindrome("asdfasdf");
        System.out.println(result);
        System.out.println(rotateString("abcde", "cdeab"));
        System.out.println(reverseStr("abcdefg", 2));
    }
    // Source : https://leetcode.com/problems/first-unique-character-in-a-string/
// Author : Hao Chen
// Date   : 2016-08-23

    /***************************************************************************************
     *
     * Given a string, find the first non-repeating character in it and return it's index.
     * If it doesn't exist, return -1.
     *
     * Examples:
     *
     * s = "leetcode"
     * return 0.
     *
     * s = "loveleetcode",
     * return 2.
     *
     * Note: You may assume the string contain only lowercase letters.
     ***************************************************************************************/
    private static int FirstUniqueCharacterInAString(String s) {

        int[] CHAR = new int[256];
        if (s == null || s.isEmpty()) return -1;

        for (int i = 0, l = s.length(); i < l; i++) {
            CHAR[s.charAt(i)]++;
        }

        for (int i = 0, l = s.length(); i < l; i++) {
            if (CHAR[s.charAt(i)] == 1) return i;
        }

        return -1;
    }

    private static boolean repeatedSubstringPattern(String s) {

        boolean found;
        for (int i = 1, l = s.length(); i < l; i++) {
            found = true;
            String subI = s.substring(0, i);
            int j = i;
            if (j >= l) return false;
            while (j < l) {
                if ((j + i) >= l + 1) return false;
                String subJ = s.substring(j, j + i);
                if (!subI.equals(subJ)) {
                    found = false;
                    break;
                }
                j += i;
            }
            if (found) return true;
        }
        return false;

    }

    private static String reverseWords(String s) {
        if (s == null || s.isEmpty()) return "";
        StringBuilder sb = new StringBuilder(s.trim());
        String reverse = sb.reverse().toString();
        StringTokenizer st = new StringTokenizer(reverse, " ");
        List<String> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            list.add(st.nextToken());
        }
        for (int i = 0, l = list.size(); i < l; i++) {
            String str = list.get(i);
            String newStr = new StringBuilder(str).reverse().toString();
            list.set(i, newStr);
        }
        StringBuilder result = new StringBuilder();
        for (String str : list) {
            result.append(str).append(" ");
        }
        return result.toString().trim();

    }

    public void reverseWords(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        for (int i = 0, j = 0, l = s.length; i < l; ) {
            if (s[i] == ' ') {
                if (s[i - 1] == ' ') {
                    j = i;
                    i++;
                    j++;
                } else {
                    i = i - 1;
                    for (int p = j, q = i; p < q; p++, q--) {
                        char temp = s[p];
                        s[p] = s[q];
                        s[q] = temp;
                    }
                    i = i + 1;
                    j = i;
                    i++;
                    j++;
                }
            } else if (i == l - 1) {
                for (int p = j, q = i; p < q; p++, q--) {
                    char temp = s[p];
                    s[p] = s[q];
                    s[q] = temp;
                }
                j = i;
                i++;
                j++;
            } else {
                i++;
            }
        }
    }

    private static int myAtoi(String str) {
        boolean isPositive = true;
        if (str == null || str.trim().isEmpty()) return 0;
        str = str.trim();
        if (str.charAt(0) == '+') {
            isPositive = true;
            str = str.substring(1, str.length());
        } else if (str.charAt(0) == '-') {
            isPositive = false;
            str = str.substring(1, str.length());
        } else if (str.charAt(0) > '9' || str.charAt(0) < '0') return 0;
        int i = 0;
        for (int l = str.length(); i < l; i++) {
            if (str.charAt(i) > '9' || str.charAt(i) < '0') break;
        }
        str = str.substring(0, i);
        long num = 0;
        for (int j = 0, l = str.length(); j < l; j++) {
            int n = (str.charAt(j) - '0');
            num *= 10;
            num += n;
            if (isPositive) {
                if (num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            } else {
                if ((num * -1) < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }
        }
        if (isPositive) return (int) num;
        else return (int) (num * -1);
    }

    private static List<String> fullJustify(String[] words, int L) {
        int wCount = 0, charCount = 0;
        List<String> line = new ArrayList<>();
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0, l = words.length; i < l; i++) {
            String next = words[i];
            if ((L - (charCount + wCount)) >= next.length()) {
                line.add(next);
                charCount += next.length();
                wCount++;
            } else {
                // justify and add to list
                sb.append(line.get(0));
                StringBuilder space = new StringBuilder();
                if (line.size() > 1) {
                    int spaceCount = (L - charCount) / (wCount - 1);
                    int remaining = (L - charCount) % (wCount - 1);

                    for (int j = 0; j < spaceCount; j++) space.append(' ');

                    for (int k = 1, kl = line.size(); k < kl; k++) {
                        sb.append(space);
                        if (remaining > 0) {
                            sb.append(' ');
                            --remaining;
                        }
                        sb.append(line.get(k));
                    }
                } else {
                    int balance = L - (charCount + (wCount - 1));
                    for (int j = 0; j < balance; j++) sb.append(' ');
                }
                result.add(sb.toString());
                sb = new StringBuilder();
                line.clear();
                line.add(next);
                charCount = next.length();
                wCount = 1;
            }
        }
        if (!line.isEmpty()) {
            sb.append(line.get(0));
            for (int i = 1, l = line.size(); i < l; i++) {
                sb.append(' ');
                sb.append(line.get(i));
            }
        }
        int balance = L - (charCount + (wCount - 1));
        for (int i = 0; i < balance; i++) sb.append(' ');
        result.add(sb.toString());
        return result;
    }

    private static String zigZagConvert(String s, int numRows) {
        if (s == null || s.length() <= numRows || numRows == 1) return s;
        List<String> list = new ArrayList<>();
        char[] A = new char[numRows];
        int direction = 1; // 1 indicates forward, 0 indicates backwards
        int n = 1;
        A[0] = s.charAt(0);
        for (int j = 1; j < numRows; ) {
            if (n >= s.length()) break;
            A[j] = s.charAt(n++);
            if (j == numRows - 1) {
                list.add(String.valueOf(A));
                A = new char[numRows];
                Arrays.fill(A, ' ');
                direction = 0;
            } else if (j == 0) {
                list.add(String.valueOf(A));
                A = new char[numRows];
                Arrays.fill(A, ' ');
                direction = 1;
            }
            j = direction == 1 ? j + 1 : j - 1;
        }
        if (!String.valueOf(A).trim().isEmpty()) list.add(String.valueOf(A));
        char[] arr = new char[s.length()];
        int k = 0;
        for (int j = 0; j < numRows; j++) {
            for (String aList : list) {
                if (aList.charAt(j) != ' ') arr[k++] = aList.charAt(j);
            }
        }
        return new String(arr).trim();
    }

    private static int compareVersion(String version1, String version2) {
        StringTokenizer st1 = new StringTokenizer(version1, ".");
        StringTokenizer st2 = new StringTokenizer(version2, ".");
        while (st1.hasMoreTokens() & st2.hasMoreTokens()) {
            int token1 = Integer.parseInt(st1.nextToken());
            int token2 = Integer.parseInt(st2.nextToken());
            if (token1 > token2) return 1;
            else if (token2 > token1) return -1;
        }
        if (st1.countTokens() > st2.countTokens()) {
            while (st1.hasMoreTokens()) {
                if (Integer.parseInt(st1.nextToken()) > 0) return 1;
            }
        } else if (st2.countTokens() > st1.countTokens()) {
            while (st2.hasMoreTokens()) {
                if (Integer.parseInt(st2.nextToken()) > 0) return -1;
            }
        }
        return 0;
    }

    private static boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return true;
        s = s.toLowerCase();
        for (int i = 0, j = s.length() - 1; i < j; ) {
            char f = s.charAt(i);
            char l = s.charAt(j);
            if (!(f >= 'a' && f <= 'z') && !(f >= '0' && f <= '9')) {
                i++;
                continue;
            }
            if (!(l >= 'a' && l <= 'z') && !(l >= '0' && l <= '9')) {
                j--;
                continue;
            }
            if (f != l) return false;
            i++;
            j--;
        }
        return true;
    }

    private static boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; ) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return isPaliandrome(s.substring(i, j)) || isPaliandrome(s.substring(i + 1, j + 1));
            }
        }
        return true;
    }

    private static boolean isPaliandrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; ) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else return false;
        }
        return true;
    }

    private static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> first = new HashMap<>();
        Map<Character, Character> second = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (first.containsKey(c)) {
                char secondC = first.get(c);
                if (t.charAt(i) != secondC) return false;
            } else {
                first.put(c, t.charAt(i));
                if (second.containsKey(t.charAt(i))) return false;
                second.put(t.charAt(i), c);
            }
        }
        return true;
    }

    private static int compress(char[] chars) {
        int count = 0;
        int i = 0;
        int p = 0;
        for (int j = 0; j < chars.length; j++) {
            if (chars[i] == chars[j]) {
                count++;
            } else {
                chars[p] = chars[i];
                p++;
                if (count > 1) {
                    String countStr = String.valueOf(count);
                    for (int l = 0; l < countStr.length(); l++) {
                        chars[p++] = countStr.charAt(l);
                    }
                }
                i = j;
                count = 1;
            }
        }
        chars[p] = chars[i];
        p++;
        if (count > 1) {
            String countStr = String.valueOf(count);
            for (int l = 0; l < countStr.length(); l++) {
                chars[p++] = countStr.charAt(l);
            }
        }
        return p;
    }

    private static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            for (int j = 0; j < result.length(); j++) {
                if (j >= s.length() || result.charAt(j) != s.charAt(j)) {
                    result = result.substring(0, j);
                    break;
                }
            }
        }
        return result;
    }

    private static int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.putIfAbsent(c, 0);
            int count = map.get(c);
            map.put(c, count + 1);
        }
        int max = 0;
        boolean odd = false;
        for (char c : map.keySet()) {
            int count = map.get(c);
            max += count;
            if ((count % 2) != 0) {
                max--;
                odd = true;
            }
        }
        if (odd) max++;
        return max;
    }

    private static boolean rotateString(String A, String B) {
        if (A.length() == 1 || A.isEmpty() || B.length() == 1 || B.isEmpty()) {
            return A.equals(B);
        } else if (A.length() != B.length()) {
            return false;
        }
        for (int i = 0, l = A.length(); i < l; i++) {
            char s = A.charAt(0);
            A = A.substring(1) + s;
            if (A.equals(B)) return true;
        }
        return false;
    }

    private static String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, l = s.length(); i < l; i++) {
            if (i % (2 * k) == 0) {
                int count = 0;
                StringBuilder temp = new StringBuilder();
                while (count < k && i < l) {
                    temp.append(s.charAt(i));
                    count++;
                    i++;
                }
                sb.append(temp.reverse());
            }
            if (i < l) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }








}
