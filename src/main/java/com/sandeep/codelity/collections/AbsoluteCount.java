package com.sandeep.codelity.collections;

import java.util.HashSet;
import java.util.Set;

public class AbsoluteCount {

    public static void main(String[] args) {
        absoluteCount();
    }

    static void absoluteCount() {

        int[] arr = {-3,-5,-7,0, 4,6,5,98};
        // using "Set"
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            // note: using "Math.abs(int)"
            if( set.contains( Math.abs(arr[i]) ) == false ){
                set.add( Math.abs(arr[i]) );
            }
            else{
                // do nothing (already existed in the set)
            }
        }

        System.out.println("The count is :"+set.size());

    }
}
