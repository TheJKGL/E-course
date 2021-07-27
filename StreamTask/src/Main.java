import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] array = {2,6,3,8,10,11,15,5,23};
        IntSummaryStatistics summaryStatistics = Arrays.stream(array).summaryStatistics();

        //First way.====================================================================
        double average1 = summaryStatistics.getAverage();
        System.out.println("Average1: " + average1);

        //Second way.====================================================================
        double average2 = Arrays.stream(array)
                .average()
                .getAsDouble();
        System.out.println("Average2: " + average2);

        //Finding min value.=============================================================
        int minValue = summaryStatistics.getMin();
        System.out.println("Min value: " + minValue);

        //Finding index of min value.====================================================
        int indexOfMin = IntStream
                .range(0,array.length)
                .reduce((i,j) -> array[i] > array[j] ? j:i)
                .getAsInt();
        System.out.println("Index of min value: " + indexOfMin);

        //Finding number of zeros.========================================================
        long numberOfZeros = Arrays.stream(array).filter(a->a==0).count();
        System.out.println("Number of zeros: " + numberOfZeros);

        //Finding the number of digits greater than zero.=================================
        long numberOfNonZeros = Arrays.stream(array).filter(a-> a > 0).count();
        System.out.println("Number of Nonzero elements: " + numberOfNonZeros);

        //Multiply the elements of the array by a number.=================================
        Arrays.stream(array).map(a -> a * 2).forEach(a-> System.out.print(a+" "));











    }
}
