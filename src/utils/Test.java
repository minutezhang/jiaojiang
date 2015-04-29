package utils;

import java.util.*;

/**
 * @author: mizhang
 * @since: Nov 30, 2014 3:21:17 PM
 */
public class Test {
    public static void assertEquals(int expected, int actual) {
        if (expected == actual) {
            System.out.println("test case passed");
        } else {
            System.err.println("test case FAILED: " + expected + " != " + actual);
        }
    }

    public static void assertEquals(double expected, double actual) {
        if (expected == actual) {
            System.out.println("test case passed");
        } else {
            System.err.println("test case FAILED: " + expected + " != " + actual);
        }
    }

    public static void assertEquals(Object expected, Object actual) {
        if (expected == null && actual == null) {
            System.out.println("test case passed");
            return;
        }

        if (expected == null || actual == null) {
            System.err.println("test case FAILED: one of the object is null");
            return;
        }

        if (expected.equals(actual)) {
            System.out.println("test case passed");
        } else {
            System.err.println("test case FAILED: (" + expected + ") != (" + actual + ")");
        }
    }

    public static void assertEquals(char[][] expected, char[][] actual) {
        if (expected == null && actual == null) {
            System.out.println("test case passed");
            return;
        }

        if (expected == null || actual == null) {
            System.err.println("test case FAILED: one of the object is null");
            return;
        }

        if (expected.length != actual.length || expected[0].length != actual[0].length) {
            System.err.println("test case FAILED: different length: (" + expected.length + "," + expected[0].length + ") vs ("
                    + actual.length + "," + actual[0].length + ")");
        }

        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[0].length; j++) {
                if (expected[i][j] != actual[i][j]) {
                    System.err.println("test case FAILED: " + expected[i][j] + " != " + actual[i][j]);
                    return;
                }
            }
        }

        System.out.println("test case passed");
    }

        public static void assertEquals(int[][] expected, int[][] actual) {
        if (expected == null && actual == null) {
            System.out.println("test case passed");
            return;
        }

        if (expected == null || actual == null) {
            System.err.println("test case FAILED: one of the object is null");
            return;
        }

        if (expected.length != actual.length || expected[0].length != actual[0].length) {
            System.err.println("test case FAILED: different length: (" + expected.length + "," + expected[0].length + ") vs ("
                    + actual.length + "," + actual[0].length + ")");
        }

        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[0].length; j++) {
                if (expected[i][j] != actual[i][j]) {
                    System.err.println("test case FAILED at <" + i + ", " + j + ">" + ": " + expected[i][j] + " != " + actual[i][j]);
                    return;
                }
            }
        }

        System.out.println("test case passed");
    }

    public static<T> void assertEquals(T[] expected, T[] actual) {
        if (expected == null && actual == null) {
            System.out.println("test case passed");
            return;
        }

        if (expected == null || actual == null) {
            System.err.println("test case FAILED: one of the array is null");
            return;
        }

        if (expected.length != actual.length) {
            System.err.println("test case FAILED: those two arrays have different lengths: " + expected.length + " vs " + actual.length);
            return;
        }

        for (int i = 0; i < expected.length; i++) {
            if (!expected[i].equals(actual[i])) {
                System.err.println("test case FAILED: element at index " + i + " : "+ expected[i] + " != " + actual[i]);
                return;
            }
        }

        System.out.println("test case passed");
    }

    public static<T> void assertEquals(int[] expected, int[] actual) {
        if (expected == null && actual == null) {
            System.out.println("test case passed");
            return;
        }

        if (expected == null || actual == null) {
            System.err.println("test case FAILED: one of the array is null");
            return;
        }

        if (expected.length != actual.length) {
            System.err.println("test case FAILED: those two arrays have different lengths: " + expected.length + " vs " + actual.length);
            return;
        }

        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != actual[i]) {
                System.err.println("test case FAILED: element at index " + i + " : "+ expected[i] + " != " + actual[i]);
                return;
            }
        }

        System.out.println("test case passed");
    }

    public static <T> void assertEquals(List<T> expected, List<T> actual) {
        if (expected == null && actual == null) {
            System.out.println("test case passed");
            return;
        }

        if (expected == null || actual == null) {
            System.err.println("test case FAILED: one of the list is null");
            return;
        }

        if (expected.size() != actual.size()) {
            System.err.println("test case FAILED: those two lists have different sizes: " + expected.size() + " vs " + actual.size());
            return;
        }

        Set<Integer> usedIndices = new HashSet<Integer>();
        for (T t : expected) {
            boolean found = false;
            for (int i = 0; i < actual.size(); i++) {
                if (!usedIndices.contains(i) && actual.get(i).equals(t)) {
                    found = true;
                    usedIndices.add(i);
                    break;
                }
            }
            if (!found) {
                System.err.println("test case FAILED: element " + t + " is not found");
                return;
            }
        }

        
        if (usedIndices.size() == expected.size()) {
            System.out.println("test case passed");
            return;
        }

        System.err.println("test case FAILED: different element");
        return;
    }
     

    public static void assertEquals(int[] expected, int[] actual, int length) {
        if (expected.length < length || actual.length < length) {
            System.err.println("test case FAILED: at least one length is less than " + length + " : " + expected.length + " vs " + actual.length);
            return;
        }

        for (int i = 0; i < length; i++) {
            if (expected[i] != actual[i]) {
                System.err.println("test case FAILED: element at index " + i + " : "+ expected[i] + " != " + actual[i]);
                return;
            }
        }
        System.out.println("test case passed");
    }

    public static void assertTrue(boolean bool) {
        if (bool) {
            System.out.println("test case passed");
        } else {
            System.err.println("test case FAILED: not TRUE");
        }
    }

    public static void assertFalse(boolean bool) {
        if (!bool) {
            System.out.println("test case passed");
        } else {
            System.err.println("test case FAILED: not FALSE");
        }
    }

    public static void printList(List<Integer> list) {
        for (int i : list) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    public static void printStringList(List<String> list) {
        for (String s : list) {
            System.out.print(s + "\t");
        }
        System.out.println();
    }

    public static void printListList(List<List<Integer>> list) {
        for (List<Integer> l : list) {
            printList(l);
        }
        System.out.println();
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    public static void printArrayWithRange(int[] array, int range) {
        for (int i = 0; i < range; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }
}
