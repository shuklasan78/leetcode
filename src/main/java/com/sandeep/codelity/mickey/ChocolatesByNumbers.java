package com.sandeep.codelity.mickey;

import java.util.HashSet;
import java.util.Set;

public class ChocolatesByNumbers {

    public static void main(String[] args) {

    }
    public int solution(int N, int M) {

        // main idea:
        // using "gcd(M, N)"
        // the number of eaten chocolates = N / gcd(M,N)
        return N/(gcd(N,M));
    }

    // using "Euclidean Algorithm" (important)
    public static int gcd(int a,int b){
        if(a % b == 0)
            return b;            // case 1
        else
            return gcd(b,a % b); // case 2 (key point)
    }

    public int solution2(int N, int M) {

        Set<Integer> set = new HashSet<>();

        int currentNumber =0;
        set.add(currentNumber); // the 1st chocolate
        int numChocolate = 1;   // eat the 1st one

        while(true){
            currentNumber = (currentNumber + M) % N;
            if(set.contains(currentNumber) == true){
                break;
            }
            else{
                numChocolate++; // eat one more chocolate
                set.add(currentNumber); // record its number
            }
        }

        return numChocolate;
    }
}
