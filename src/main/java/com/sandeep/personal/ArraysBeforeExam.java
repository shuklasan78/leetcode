package com.sandeep.personal;

import com.sandeep.personal.data.CSVDataProcessor;
import com.sandeep.personal.data.SalesVO;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArraysBeforeExam {

    public static void main(String[] args) {
        //getArrayFromList();
        //extractStringFromArray();
        sortStringArray();
        //extractIntegerArrayFromOject();
        sortIntegerInIntArry();
    }

    static  SalesVO[] getArrayFromList() {

        List<SalesVO> salesRecords  = CSVDataProcessor.readSalesCSVFile("SalesRecords100");
        // create arrays based on lsit objects
        SalesVO[] salesArray = new SalesVO[salesRecords.size()];
        salesArray = salesRecords.toArray(salesArray);
        return salesArray;
    }

    static String[] extractStringFromArray() {
        SalesVO[] salesArray = getArrayFromList();
        // extract String array from Arrays of Sales
        String[] countryArray = (String[]) Arrays.stream(salesArray).map(p -> p.getCountry()).toArray(String[] :: new);
        return countryArray;
    }

    static void sortStringArray() {
        String[] countryArray = extractStringFromArray();
        //sort accending order
        Arrays.sort(countryArray);
        System.out.println("FirstElement-String Using Normal Sort :"+countryArray[0]+"  LastElement-String Using Normal Sort:"+countryArray[countryArray.length-1]);
        //stream sorting in natural order
        String[] countryArrayStreamNaturalOrder = extractStringFromArray();
        countryArrayStreamNaturalOrder = Arrays.stream(countryArrayStreamNaturalOrder).sorted().toArray(String[] :: new);
        System.out.println("FirstElement-String-UisngStream :  "+countryArrayStreamNaturalOrder[0]+"   LstValue-String-UisngStream :  "+countryArrayStreamNaturalOrder[countryArrayStreamNaturalOrder.length-1]);

        //stream sorting in reverse order
        countryArrayStreamNaturalOrder = Arrays.stream(countryArrayStreamNaturalOrder).sorted(Collections.reverseOrder()).toArray(String[] :: new);
        System.out.println("Reverse-String-FirstElementUisngStream :  "+countryArrayStreamNaturalOrder[0]+  "   String-ReverseLstValueUisngStream :"+countryArrayStreamNaturalOrder[countryArrayStreamNaturalOrder.length-1]);

    }

    static int[] extractIntegerArrayFromOject() {
        SalesVO[] salesArray = getArrayFromList();
        int[] intArray = Arrays.stream(salesArray).mapToInt( p -> p.getOrderID()).toArray();
        return intArray;
    }

    static void sortIntegerInIntArry() {
        int[] intArray = extractIntegerArrayFromOject();
        System.out.println("The size of the int is :"+intArray.length);
        System.out.println("FirstElement Without sort:   + "+intArray[0]+"    LastElement Without sort : "+intArray[intArray.length-1]);
        //sorting in natural order
        int[] sortedIntArray = IntStream.of(intArray).boxed().sorted().mapToInt( i -> i).toArray();
        System.out.println("Natural-FirstElementSorted :   + "+sortedIntArray[0]+"    Natural-LastElementSorted : "+sortedIntArray[intArray.length-1]);

        //soting in decending order
        int[] sortedIntArrayReverse = IntStream.of(sortedIntArray).boxed().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();
        System.out.println("Reverse-FirstElementSorted :   + "+sortedIntArrayReverse[0]+"    Reverse-LastElementSorted : "+sortedIntArrayReverse[sortedIntArrayReverse.length-1]);

    }
}
