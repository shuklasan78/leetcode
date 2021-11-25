package com.sandeep.personal;

public class MathsBeforeExam {

    public static void main(String[] args) {
        basicMaths();
    }

    static void basicMaths() {

        double x = 4;
        double y = 3;

        // return the maximum of two numbers
        System.out.println("Maximum number of x and y is: " +Math.max(x, y));

        // return the square root of y
        System.out.println("Square root of y is: " + Math.sqrt(y));
        System.out.println("Cobe root of y is: " + Math.cbrt(y));
        //returns 28 power of 4 i.e. 28*28*28*28
        System.out.println("Power of x and y is: " + Math.pow(x, y));

        int l = 78;
        int m = -48;
        //print the absolute value of int type
        System.out.println(Math.abs(l));
        System.out.println(Math.abs(m));
        System.out.println("Sign of Number "+Math.signum(m));

    }
}
