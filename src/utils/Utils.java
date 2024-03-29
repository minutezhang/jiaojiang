package utils;

import java.util.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author: mizhang
 * @since: Sep 10, 2013 10:52:40 AM
 */
public class Utils {

    public static String[] getStringArray(String filename) {
        InputStream is  = Utils.class.getResourceAsStream("/" + filename);
        try {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            String[] ret = new String[Integer.parseInt(line)];

            for ( int i = 0; i < ret.length && (line = br.readLine()) != null; i++) {
                ret[i] = line;
            }

            br.close();
            isr.close();
            is.close();

            return ret;
        } catch (IOException e) {
            return new String[0];
        }
    }

    public static int[] getIntArray(String filename) {
        return fromStringArray(getStringArray(filename));
    }

    private static int[] fromStringArray(String[] stringArray) {
        int[] ret = new int[stringArray.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = Integer.parseInt(stringArray[i]);
        }
        return ret;
    }

    private static int[] fromString(String line) {
        String[] dataStr = line.split(",");
        int[] array = new int[dataStr.length];
        for (int i = 0; i < dataStr.length; i++) {
            array[i] = Integer.parseInt(dataStr[i]);
        }

        return array;
    }


    public static int[][] get2DIntArray(String filename) {
        InputStream is  = Utils.class.getResourceAsStream("/" + filename);
        try {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String[] dimension = br.readLine().split(",");
            int[][] ret = new int[Integer.parseInt(dimension[0])][Integer.parseInt(dimension[1])];

            String line;
            for ( int i = 0; i < ret.length && (line = br.readLine()) != null; i++) {
                ret[i] = fromString(line);
            }

            br.close();
            isr.close();
            is.close();

            return ret;
        } catch (IOException e) {
            return new int[0][0];
        }
    }

    public static Integer[] getIntegerArray(String filename) {
        InputStream is  = Utils.class.getResourceAsStream("/" + filename);
        try {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            Integer[] ret = new Integer[Integer.parseInt(line)];

            for ( int i = 0; i < ret.length && (line = br.readLine()) != null; i++) {
                ret[i] = Integer.parseInt(line);
            }

            br.close();
            isr.close();
            is.close();

            return ret;
        } catch (IOException e) {
            return new Integer[0];
        }
    }

    public static List<Integer> toList(int[] data) {
        List<Integer> ret = new ArrayList<Integer>();

        for (int i : data) {
            ret.add(i);
        }

        return ret;
    }

    public static Set<Integer> toSet(int[] data) {
        Set<Integer> ret = new HashSet<Integer>();

        for (int i : data) {
            ret.add(i);
        }

        return ret;
    }


    public static<T> List<T> getList(T[] object) {
        List<T> list = new ArrayList<T>()  {
            @Override
            public boolean equals(Object anotherList) {
                if (anotherList.getClass() != this.getClass()) {
                    return false;
                }

                if ( ((ArrayList<T>) anotherList).size() != this.size()) {
                    return false;
                }

                for (int i = 0; i < this.size(); i++) {
                    if ( ((ArrayList<T>) anotherList).get(i).equals(this.get(i))) {
                        return false;
                    }
                }

                return true;
            }
        };

        for (T t : object) {
            list.add(t);
        }

        return list;
    }


    public static<T> List<T> getList(Collection<T> object) {
        List<T> list = new ArrayList<T>()  {
            @Override
            public boolean equals(Object anotherList) {
                if (anotherList.getClass() != this.getClass()) {
                    return false;
                }

                if ( ((ArrayList<T>) anotherList).size() != this.size()) {
                    return false;
                }

                for (int i = 0; i < this.size(); i++) {
                    if ( ((ArrayList<T>) anotherList).get(i).equals(this.get(i))) {
                        return false;
                    }
                }

                return true;
            }
        };

        for (T t : object) {
            list.add(t);
        }

        return list;
    }

    public static void printTestln(Object get, Object expected) {
        if (get == null && expected == null) {
            System.out.println("get: null, expected: null");
        } else if (get == null){
            System.out.println("[ERROR] get: null, expected: " + expected.toString());
        } else if (expected == null) {
            System.out.println("[ERROR] get: "+ get.toString() + ", expected: null");
        } else if (get.equals(expected)) {
            System.out.println("get: " + get.toString() + ", expected: " + expected.toString());
        } else {
            System.out.println("[ERROR] get: " + get.toString() + ", expected: " + expected.toString());
        }
    }

    public static void printTestBooleanArrayln(boolean[] get, boolean[] expected) {
        for (int i = 0; i < get.length; i++) {
            if (get == expected) {
                System.out.println("get: " + get[i] + ", expected: " + expected[i]);
            } else {
                System.out.println("[ERROR] get: " + get[i] + ", expected: " + expected[i]);
            }
        }
        System.out.println();
    }

    public static void printArrayln(String[] data, String dilimit) {
        for (String s : data) {
            System.out.print(s + dilimit);
        }
        System.out.println();
    }

    public static void printArrayln(String[] data) {
        printArrayln(data, "\t");
    }

    public static void printArrayln(char[] data) {
        for (char c : data) {
            System.out.print(c + "\t");
        }
        System.out.println();
    }

    public static void printArrayln(int[] data) {
        for (int i : data) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    public static void printArrayln(long[] data) {
        for (long i : data) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    public static void print2DArrayln(int[][] data) {
        for (int[] i : data) {
            printArrayln(i);
        }
    }

    public static void print2DArrayln(char[][] data) {
        for (char[] i : data) {
            printArrayln(i);
        }
    }

    public static void printArrayRangeln(char[] charSeq, int start, int end) {
        if (end > charSeq.length) {
            end = charSeq.length;
        } else if (end < 0) {
            return;
        }

        for (int i = 0; i < end; i++) {
            System.out.print(charSeq[start + i]);
        }
    }

    public static void printArrayRangeln(char[] charSeq, int end) {
        printArrayRangeln(charSeq, 0, end);
    }

    public static void printList(List data) {
        for (Object o : data) {
            System.out.print(o.toString() + "\t");
        }
        System.out.println();
    }

    public static void printListln(List data) {
        for (Object o : data) {
            System.out.print(o.toString() + "\n");
        }
        System.out.println();
    }

    public static void printListln(List data, String dilimit) {
        for (Object o : data) {
            System.out.print(o.toString() + dilimit);
        }
        System.out.println();
    }

    public static void printListListln(List<? extends List> data) {
        for (List l : data) {
            printList(l);
        }
        System.out.println();
    }

    public static void printListArrayln(List<String[]> data, String dilimit) {
        for (String[] l : data) {
            printArrayln(l, dilimit);
        }
        System.out.println();
    }

    public static void printListArrayln(List<String[]> data) {
        printListArrayln(data, "\t");
    }

    public static void printIntListln(List<Integer> data) {
        for (int i : data) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    public static void printTestArrayln(int[] get, int[] expected) {
        int getLength = get.length, expectedLength = expected.length, length;
        if (getLength != expectedLength) {
            System.out.println("[ERROR] Integer Array Lengths do not match: " + getLength + " vs " + expectedLength);
        }
        length = Math.min(getLength, expectedLength);
        for (int i = 0; i < length; i++) {
            if (get[i] == expected[i]) {
                System.out.println("get: " + get[i] + ", expected: " + expected[i]);
            } else {
                System.out.println("[ERROR] get: " + get[i] + ", expected: " + expected[i]);
            }
        }
        System.out.println();
    }

    public static void printTestListln(List<Integer> get, List<Integer> expected) {
        int getSize = get.size(), expectedSize = expected.size(), size;
        if (getSize != expectedSize) {
            System.out.println("[ERROR] Integer List Sizes do not match: " + getSize + " vs " + expected.size());
        }
        size = Math.min(getSize, expectedSize);
        for (int i = 0; i < size; i++) {
            if (get.get(i).equals(expected.get(i))) {
                System.out.println("get: " + get.get(i) + ", expected: " + expected.get(i));
            } else {
                System.out.println("[ERROR] get: " + get.get(i) + ", expected: " + expected.get(i));
            }
        }
        System.out.println();
    }

    public static void swap(char[] input, int i, int j) {
        if (i == j || i < 0 || j < 0 || i >= input.length || j >= input.length) {
            return;
        }

        input[i] ^= input[j];
        input[j] ^= input[i];
        input[i] ^= input[j];
    }

     public static void swap(int[] input, int i, int j) {
        if (i == j || i < 0 || j < 0 || i >= input.length || j >= input.length) {
            return;
        }

        input[i] ^= input[j];
        input[j] ^= input[i];
        input[i] ^= input[j];
    }

    public static void printElapsedTime(long time, String method) {
        System.out.println("It took " + (System.nanoTime() - time) / 1000000 + "ms to run method " + method);
    }
}
