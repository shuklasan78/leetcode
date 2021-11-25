package com.sandeep.personal;

import com.sandeep.personal.data.CSVDataProcessor;
import com.sandeep.personal.data.SalesVO;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArraysBeforeExam {

    public static void main(String[] args) {
        //getArrayFromList();
        //extractStringFromArray();
        //sortStringArray();
        //extractIntegerArrayFromOject();
        //sortIntegerInIntArry();
        //splitArrays();
        //removeElementFromArray();
        insertInArray();
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

        //sorting integer into decending order.
        //Using optional to get the value from the Arrays
        OptionalInt intOptional = Arrays.stream(sortedIntArrayReverse).findFirst();
        System.out.println("Printing the first value using optional."+intOptional.getAsInt());
        SalesVO[] salesArray = getArrayFromList();
        double[] unitcostArr = Arrays.stream(salesArray).mapToDouble(p -> p.getUnitCost()).toArray();
        boolean doubleOptional = Arrays.stream(unitcostArr).filter(p -> p== 524.96).findAny().isPresent();
        System.out.println("The optional finding any specific value  :"+doubleOptional);
        OptionalDouble optDouble = Arrays.stream(unitcostArr).filter(p -> p > 524.96).findAny();
        System.out.println("The optional finding any specific value  :"+optDouble.isPresent());

    }
    // remove element from array using java 8
    static void removeElementFromArray() {
        SalesVO[] salesVO = getArrayFromList();
        int[] orderIdArr = Arrays.stream(salesVO).mapToInt(i -> i.getOrderID()).toArray();
        //getting the index of the number using list
        int indexOfId = Arrays.asList(orderIdArr).indexOf(669165933);
        //getting index of the array using streams
        int indexOfId2 = IntStream.range(0, orderIdArr.length)
                .filter(i ->688288152 == orderIdArr[i])
                .findFirst() // first occurrence
                .orElse(-1); // No element found
        System.out.println("The size of the arrays are :"+orderIdArr.length);
        System.out.println("Index of the OrderId before sorting is 688288152:"+indexOfId2);
        //remover element from

        int[] afterRemoveArray = IntStream.range(0, orderIdArr.length)
                .filter(i -> i != indexOfId2)
                .map(i -> orderIdArr[i])
                .toArray();
        System.out.println("Size of Array of streams after removing an element :"+afterRemoveArray.length);

        // using copy array
        // Destination array
        int[] orderIdSystemArr = Arrays.stream(salesVO).mapToInt(i -> i.getOrderID()).toArray();
        int[] arrOut = new int[orderIdSystemArr.length - 1];
        int remainingElements = orderIdSystemArr.length - ( indexOfId2 + 1 );
        // copying elements that come before the index that has to be removed
        System.arraycopy(orderIdSystemArr, 0, arrOut, 0, indexOfId2);
        // copying elements that come after the index that has to be removed
        System.arraycopy(orderIdSystemArr, indexOfId2 + 1, arrOut, indexOfId2, remainingElements);
        //System.out.println("Elements -- "  + Arrays.toString(arrOut));
        System.out.println("Elements Length-- "  + arrOut.length);


        //using copyArray
        //int[] result = new int[orderIdArr.length - 1];
        //System.arraycopy(orderIdArr, 0, result, 0, indexOfId);
        //System.arraycopy(orderIdArr, indexOfId + 1, result, indexOfId, orderIdArr.length - indexOfId - 1);

        //using list
        List<Integer> result2 = IntStream.of(orderIdArr).boxed().collect(Collectors.toList());
        System.out.println("The size of the list before removing the element is :"+result2.size());
        result2.remove(indexOfId2);
        System.out.println("The size of the list After removing the element is :"+result2.size());
    }
//The most efficient one is using ArrayList to add a new element.
// We just convert the array to the ArrayList and then add the element to the list.
// Then we convert the ArrayList back to the array.
    static void insertInArray() {

        SalesVO[] salesVO = getArrayFromList();
        int[] orderIdArr = Arrays.stream(salesVO).mapToInt(i -> i.getOrderID()).toArray();
        //adding element in array
        int[] destArray = Arrays.copyOf(orderIdArr, orderIdArr.length + 1);
        destArray[destArray.length - 1] = 688288151;
        System.out.println("The size of the array after adding  :"+destArray.length);

        List<Integer> lstInt = IntStream.of(orderIdArr).boxed().collect(Collectors.toList());
        lstInt.add(688288199);
        int[] newArra = lstInt.stream().mapToInt(i -> i).toArray();
        System.out.println("Size of the new array is :"+newArra.length);
    }
    //splitting arrays into number of chubks
    static void splitArrays() {

        SalesVO[] saleArray = getArrayFromList();
        int[] input = Arrays.stream(saleArray).mapToInt(p -> p.getOrderID()).toArray();
        //int[] input = {1,2,3,4,78, 999,-1,456};
        int chunkSize = 9;

        int [][] chunked = IntStream.iterate(0, i -> i + chunkSize)
                .limit((long)Math.ceil((double) input.length / chunkSize))
                .mapToObj(j -> Arrays.copyOfRange(input,j,j+chunkSize>input.length ?input.length : j+chunkSize))
                .toArray(int[][] :: new);
        //.mapToObj(j -> Arrays.copyOfRange(input,j,Math.min(j + chunkSize , input.length)))
        Arrays.stream(chunked)
                .map(Arrays::toString)
                .forEach(System.out :: println);
        // Math.min(j + chunksize , input.lenghth) = j+chunkSize>input.length ?input.length : j+chunkSize
        for(int i = 0 ; i < chunked[0].length; i++) {
            System.out.println("Values "+chunked[0][i]);
        }
    }
    static void programmingConceptBeforeExam() {

    }


    static void listExample() {
        List<SalesVO> operatedList = new ArrayList<>();
        operatedList.stream()
                .filter(item -> item.getUnitCost()>20)
                .forEach(item -> {
                    item.getUnitCost();
                    operatedList.add(item);
                });
        operatedList.removeAll(operatedList);


    }
}
