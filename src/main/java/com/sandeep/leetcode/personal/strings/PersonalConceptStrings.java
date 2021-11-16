package com.sandeep.leetcode.personal.strings;

public class PersonalConceptStrings {
   public static void main(String[] args) {
        String palindrome = "121";
       // getPalindromeWhile(palindrome);
        getPalindromeFor(palindrome);
    }

    private static void getPalindromeFor(String palindrome) {
        String x, y = "";
        x = palindrome;
        int l = palindrome.length();
        for(int k = l - 1; k >= 0; k--)
        {
            y = y + x.charAt(k);
        }
        if(x.equals(y)) {
            System.out.println("It is palindrome number :");
        } else {
            System.out.println("It is not palindrome number");
        }
    }

    private static void getPalindromeWhile(String palindrome) {
        String revers = "";
        boolean flag = false;
        int i = 0, j = palindrome.length() - 1;

        while (i<j) {
            if( palindrome.charAt(i)==palindrome.charAt(j)) {
                flag = true;
            } else {
                System.out.println("It is not plaindrome");
            }
            i++;
            j--;
        }
        System.out.println(" palindrome status "+flag);
    }


}
