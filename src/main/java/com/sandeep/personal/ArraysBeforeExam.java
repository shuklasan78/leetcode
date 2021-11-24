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
        //sortStringArray();
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
        System.out.println("FirstElement :"+countryArray[0]+"   LstValue :"+countryArray[countryArray.length-1]);
        //stream sorting in natural order
        String[] countryArrayStreamNaturalOrder = extractStringFromArray();
        Arrays.stream(countryArrayStreamNaturalOrder).sorted();
        System.out.println("FirstElementUisngStream :  "+countryArrayStreamNaturalOrder[0]+"   LstValueUisngStream :  "+countryArrayStreamNaturalOrder[countryArrayStreamNaturalOrder.length-1]);

        //stream sorting in reverse order
        String[] countryArrayStreamReverse = extractStringFromArray();
        countryArrayStreamReverse = Arrays.stream(countryArrayStreamReverse).sorted(Collections.reverseOrder()).toArray(String[] :: new);
        System.out.println("ReverseFirstElementUisngStream :  "+countryArrayStreamNaturalOrder[0]+  "   ReverseLstValueUisngStream :"+countryArrayStreamNaturalOrder[countryArrayStreamNaturalOrder.length-1]);

    }

    static int[] extractIntegerArrayFromOject() {
        SalesVO[] salesArray = getArrayFromList();
        int[] intArray = Arrays.stream(salesArray).mapToInt( p -> p.getOrderID()).toArray();
        System.out.println("The zide of the int is :"+intArray.length);
        System.out.println("FirstElement :   + "+intArray[0]+"    LastElement : "+intArray[intArray.length-1]);

        return intArray;
    }

    static void sortIntegerInIntArry() {
        int[] intArray = extractIntegerArrayFromOject();
        //sorting in natural order
        int[] sortedIntArray = IntStream.of(intArray).boxed().sorted().mapToInt( i -> i).toArray();
        System.out.println("Natural-FirstElementSorted :   + "+intArray[0]+"    Natural-LastElementSorted : "+intArray[intArray.length-1]);

        //soting in decending order
        int[] sortedIntArrayReverse = IntStream.of(intArray).boxed().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();
        System.out.println("Reverse-FirstElementSorted :   + "+sortedIntArrayReverse[0]+"    Reverse-LastElementSorted : "+sortedIntArrayReverse[intArray.length-1]);


    }
}
