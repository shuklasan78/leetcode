package com.sandeep.leetcode.personal.maths;

public class BasicMaths {

    public static void main(String[] args) {

        evenOddPrimeNumber(21);
        evenOddPrimeNumberInRange(10,20);
        palinDromeNumber(12344321);
        getFactorial(5);
    }

    private static void evenOddPrimeNumber(int i) {

        if(i<0) {
            System.out.println("Not a prime number  :"+i);
        } else if( i==2) {
            System.out.println("Number is prime");
        } else if (i%2==0) {
            System.out.println("Number is prime");
        } else if(i%2 !=0) {
            System.out.println("The number is odd number :");
        }
        for( int j =3; j < i/2 ;j++) {
            if(j%2==0) {
               // System.out.println("Not a aprime number");
            } else {
               // System.out.println("It is prime number");
            }
        }
    }

    private static void evenOddPrimeNumberInRange(int i, int j) {

    }

    private static void palinDromeNumber(int i) {

    }

    private static void getFactorial(int j) {

    }

}
