package com.sandeep.leetcode.personal.strings;

import java.util.HashMap;

public class PersonalConceptStrings {
  public static void main(String[] args) {
        String palindrome = "121";
       // getPalindromeWhile(palindrome);
        //getPalindromeFor(palindrome);
        //checkPalindromeNumber(9009);
        //checkPalindromeSentence();
        String str = "GEEKSFORGEEKS";
        System.out.print(findLongestSubstring(str));
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

    private static void checkPalindromeNumber(int num) {
        String number = String.valueOf(num);
        getPalindromeWhile(number);
        //9009
        int numb = num, reversedNum = 0, remainder;
        //get reverse of original number and store them in variable
        while(numb>0) {
            remainder = numb % 10 ;
            reversedNum = reversedNum * 10 + remainder;
            //numb /= 10;
            numb = numb/10;
            System.out.println("remainder    :"+remainder+"   reversedNum    :"+reversedNum +"  numb    :"+numb);
        }
        System.out.println("The ReverseNumber  :"+reversedNum);
    }

    private static boolean checkPalindromeSentence() {
        boolean flag = false;
        String s = "A man, a plan, a canal: Panama";
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]","");
        StringBuilder reverseSb = new StringBuilder(s);
        String reverse  = reverseSb.reverse().toString();
        System.out.println("S  :"+s);
        System.out.println("reverse  :"+reverse);

        for (int i=0; i < s.length()/2; i++){
            if (s.charAt(i) != s.charAt(s.length()-i-1)) {
                flag = false;
            }
                return flag;
        }
        flag = true;
        System.out.println("The value is  :"+flag);
        return flag;

    }

    // Function to find and print longest
// substring without repeating characters.
    public static String findLongestSubstring(String str)
    {
        int i;
        int n = str.length();

        // Starting point
        // of current substring.
        int st = 0;

        // length of
        // current substring.
        int currlen = 0;

        // maximum length
        // substring without
        // repeating characters.
        int maxlen = 0;

        // starting index of
        // maximum length substring.
        int start = 0;

        // Hash Map to store last
        // occurrence of each

        // already visited character.
        HashMap<Character,
                                Integer> pos = new HashMap<Character,
                Integer>();

        // Last occurrence of first
        // character is index 0;
        pos.put(str.charAt(0), 0);

        for (i = 1; i < n; i++)
        {
            // If this character is not present in hash,
            // then this is first occurrence of this
            // character, store this in hash.
            if (!pos.containsKey(str.charAt(i)))
            {
                pos.put(str.charAt(i), i);
            }
            else
            {
                // If this character is present
                // in hash then this character
                // has previous occurrence,
                // check if that occurrence
                // is before or after starting
                // point of current substring.
                if (pos.get(str.charAt(i)) >= st)
                {
                    // find length of current
                    // substring and update maxlen
                    // and start accordingly.
                    currlen = i - st;
                    if (maxlen < currlen)
                    {
                        maxlen = currlen;
                        start = st;
                    }

                    // Next substring will start
                    // after the last occurrence
                    // of current character to avoid
                    // its repetition.
                    st = pos.get(str.charAt(i)) + 1;
                }

                // Update last occurrence of
                // current character.
                pos.replace(str.charAt(i), i);
            }
        }

        // Compare length of last
        // substring with maxlen and
        // update maxlen and start
        // accordingly.
        if (maxlen < i - st)
        {
            maxlen = i - st;
            start = st;
        }

        // The required longest
        // substring without
        // repeating characters
        // is from str[start]
        // to str[start+maxlen-1].
        return str.substring(start,
                start +
                        maxlen);
    }

    private static void getLongestSubstringWithKUniqueCharacters(String s) {

    }
}
