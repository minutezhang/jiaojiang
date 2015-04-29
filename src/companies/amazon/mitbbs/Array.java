package companies.amazon.mitbbs;

import java.util.HashSet;
import java.util.Arrays;

/**
 * @author: zhang
 * @since: Jul 26, 2010 9:30:34 PM
 */
public class Array {

    public static void removeDuplicate(int[] array) {
        HashSet<Integer> sets = new HashSet<Integer>();
        for (int i : array) {
            sets.add(i);
        }
        for (Integer i : sets) {
            System.out.println(i);
        }
    }

    public static int[] removeDuplicateNoSet(int[] array) {
        Arrays.sort(array);
        int write = 0;
        for (int i = 1, n = array.length; i < n; i++) {
            if (array[i] != array[write]) {
                array[++write] = array[i];
            }
        }

        return Arrays.copyOf(array, write);
    }

    public static void interleave(int[] array) {
        int nextIdx = 0, index = 1, count = 0, tmpStorage = array[index];
        final int frontier = array.length / 2 ;
        while (nextIdx != 1) {
            if (index >= frontier) {
                nextIdx = 2 * (index - frontier) + 1;
            } else {
                nextIdx = index * 2;
            }

            tmpStorage ^= array[nextIdx];
            array[nextIdx] ^= tmpStorage;
            tmpStorage ^= array[nextIdx];
            index = nextIdx;
        }
    }

    public static double findMedian(double[] intsA, double[] intsB) {
        return findMedian(intsA, 0, intsA.length, intsB, 0, intsB.length);
    }

    public static double findMedian(double[] intsA, int fromA, int toA, double[] intsB, int fromB, int toB) {

        if (toA - fromA != toB - fromB) {
            System.out.println("Warning: length does not equal");
            System.out.println(fromA + " : " + toA + " : " + fromB + " : " + toB);
            return 0;
        }
        double medianA = median(intsA, fromA, toA);
        double medianB = median(intsB, fromB, toB);

        if (toA - fromA == 1) {
            return (intsA[fromA] + intsB[fromB]) / 2;
        }

        if (medianA == medianB) {
            return medianA;
        }

        if (medianA < medianB) {
            return findMedian(intsA, toA + fromA >> 1, toA, intsB, fromB, toB + fromB + 1>> 1);
        }

        return findMedian(intsA, fromA, toA + fromA + 1>> 1, intsB, toB + fromB >> 1, toB);
    }

    public static double median(double[] ints, int from, int to) {
        if (((to - from)^1) == 1) {
            return ints[(to + from) >> 1];
        }

        return (ints[(to + from) >> 1] + ints[((to + from) >> 1) - 1]) / 2 ;
    }

    public static int rotatedBinarySearch(int[] data, int target) {
        int mid, low = 0, high = data.length - 1;
         
        while (low <= high) {
            mid = low + high >> 1;
            if (data[mid] == target) {
                return mid;
            }

            if (data[mid] < target) {
                if (data[mid] >= data[0]) {
                    low = mid + 1;
                } else if (target == data[0]) {
                    return 0;
                } else if (target > data[0]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (data[mid] <= data[0]) {
                    high = mid - 1;
                } else if (target == data[0]) {
                    return 0;
                } else if (target < data[0]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void circularPrint(int[][] squareArray) {
        int n = squareArray.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                System.out.println(squareArray[i][j]);
            }
            for (int j = i; j < n - i - 1; j++) {
                System.out.println(squareArray[j][n - 1 - i]);
            }
            for (int j = i; j < n - i - 1; j++) {
                System.out.println(squareArray[n - i - 1][n - 1 - j]);
            }
            for (int j = i; j < n - i - 1; j++) {
                System.out.println(squareArray[n - 1 - j][i]);
            }
        }
    }

    public static void rotate(int[][] array) {
        int tmp;
        for (int i = 0; i < array.length / 2; i++) {
            for (int j = i; j < array.length - i - 1; j++) {
                tmp = array[i][j];
                array[i][j] = array[array.length - j - 1][i];
                array[array.length - j - 1][i] = array[array.length - i - 1][array.length - j - 1];
                array[array.length - i - 1][array.length - j - 1] = array[j][array.length - i - 1];
                array[j][array.length - i - 1] = tmp;
//                array[i][j] ^= array[j][array.length - i - 1];
//                array[j][array.length - i - 1] ^= array[i][j];
//                array[i][j] ^= array[j][array.length - i - 1];
//
//                array[i][j] ^= array[array.length - i - 1][array.length - j - 1];
//                array[array.length - i - 1][array.length - j - 1] ^= array[i][j];
//                array[i][j] ^= array[array.length - i - 1][array.length - j - 1];
//
//                array[i][j] ^= array[array.length - j - 1][i];
//                array[array.length - j - 1][i] ^= array[i][j];
//                array[i][j] ^= array[array.length - j - 1][i];
            }
        }
    }

    public static int binarySearch(int[] array, int target) {
        int low = 0, high = array.length - 1, mid;

        while (low <= high) {
            mid = (low + high) >>> 1;
            if (array[mid] == target) {
                return mid;
            }

            if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] argv) {
//        int[] integers = {1, 2, 2, 2, 3, 4, 4, 5, 5, 6};
//        removeDuplicate(integers);
        int[] integers = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(binarySearch(integers, 8));


//        int[] noDup = removeDuplicateNoSet(integers);
//        for (int i : noDup) {
//            System.out.printTestln(i);
//        }
//        interleave(integers);
//        for (int i : integers) {
//            System.out.printTestln(i);
//        }
//
//        double[] a = {1, 4, 7, 13, 14, 18, 20, 30};
//        double[] b = {2, 3, 5, 8, 9, 12, 16, 29};
//        System.out.printTestln(findMedian(a, b));

//        int[] a = {16, 18, 20, 22, 2, 4, 6, 8, 10, 12, 14};
//        for (int i = 0; i < a.length; i++) {
//            System.out.printTestln(rotatedBinarySearch(a, a[i]));
//        }

//        int[][] as = {{1,2,3,4,17}, {5,6,7,8,18},{9,10,11,12,19},{13,14,15,16,20}, {21,22,23,24,25}};

//        circularPrint(as);
//        for (int i = 0; i < as.length; i++) {
//            for (int j = 0; j < as[i].length; j++) {
//                System.out.print(as[i][j] + " ");
//            }
//            System.out.printTestln();
//        }
//
//        System.out.printTestln("");
//        rotate(as);
//
//        for (int i = 0; i < as.length; i++) {
//            for (int j = 0; j < as[i].length; j++) {
//                System.out.print(as[i][j] + " ");
//            }
//            System.out.printTestln();
//        }
    }
}
