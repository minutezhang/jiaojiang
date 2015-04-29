package jiaojiang.huayuan;

import utils.Utils;

public class Combination {
    public static void printCombination(String input) {
        printCombination(new char[input.length()], 0, input.toCharArray(), 0);
    }
    //print the combination of input String, the length of the combination is "length"
    public static void printCombination(String input, int length) {
        printCombination(new char[input.length()], 0, input.toCharArray(), 0, length);
    }

    public static void printCombination(char[] prefix, int write, char[] input, int read) {
        if (read == input.length) {
            Utils.printArrayRangeln(prefix, write);
            return;
        }

        //check duplicates
        int i  = 0;
        for (; i < write; i++) {
            if (prefix[i] == input[read]) {
                break;
            }
        }

        if (i == write) {
            printCombination(prefix, write, input, read + 1);
            prefix[write] = input[read];
            printCombination(prefix, write + 1, input, read + 1);
        }
    }

    public static void printCombination(char[] prefix, int write, char[] input, int read, int length) {

        if (read == input.length) {
            if (write == length) {
                Utils.printArrayRangeln(prefix, write);
            }
            return;
        }

        int i = 0;
        for (; i < write; i++) {
            if (prefix[i] == input[read]) {
                break;
            }
        }

        if (i == write) {
            printCombination(prefix, write, input, read + 1, length);
            prefix[write] = input[read];
            printCombination(prefix, write + 1, input, read + 1, length);
        }
    }


    public static void main(String[] argv) {
        String str = "abcded";
        printCombination(str, 3);
    }

}
