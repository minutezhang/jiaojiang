package companies.linkedin.glassdoor;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author: zhang
 * @since: Aug 29, 2010 2:03:11 PM
 */
public class Arrays {

    public static boolean isSum(int[] array, int target) {
        Map<Integer, Integer> lookup = new HashMap<Integer, Integer>();

        for (int i : array) {
            if (lookup.containsKey(target - i)) {
                return true;
            }

            lookup.put(i, 1);
        }

        return false;
    }

    public static void shuffle(int[] array) {
        Random r = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = r.nextInt(i);
            array[i] ^= array[index];
            array[index] ^= array[i];
            array[i] ^= array[index]; 
        }
    }

    public static int kthOrder(int[] array, int k) {
        return kthOrder(array, 0, array.length, k);
    }

    public static int kthOrder(int[] array, int from , int to, int k) {

        if (to - from == 1) {
            return array[from];
        }
        
        int i = from, pivot = array[from];
        for (int j = from + 1; j < to; j++) {
            if(array[j] > pivot) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
            }
        }
        
        if (i - from < k) {
            return kthOrder(array, i, to, k - i + from);
        }

        return kthOrder(array, from, i, k);
        
    }

    public static void printPaths(int[][] array) {
        int[] paths = new int[array.length + array[0].length - 1];
        printPaths(array, 0, 0, paths);
    }

    public static void printPaths(int[][] array, int rowFrom, int colFrom, int[] paths) {
        paths[rowFrom + colFrom] = array[rowFrom][colFrom];

        if (array.length == rowFrom + 1 && array[rowFrom].length == colFrom + 1) {
            Sorting.print(paths);
            return;
        }

        if(rowFrom + 1 < array.length) {
            printPaths(array, rowFrom + 1, colFrom, paths);
        }
        
        if (colFrom + 1 < array[rowFrom].length) {
            printPaths(array, rowFrom, colFrom + 1, paths);
        }
    }

    public static void main(String[] argv) {
//        int[] array = new int[] {1, 1, 4, 5, 8, 10};
//        System.out.printTestln(isSum(array, 16));
//        shuffle(array);
//        Sorting.print(array);
//        System.out.printTestln(kthOrder(array, 2));

        int[][] array = {{1, 2, 3, 11}, {4, 5, 6, 12}, {7, 8, 9, 13}};
        printPaths(array);
    }
}
