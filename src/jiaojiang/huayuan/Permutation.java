package jiaojiang.huayuan;

import utils.Utils;


public class Permutation {
    public static void printPermutation(String input) {
        char[] chars = input.toCharArray();
        printPermutationHelper(chars, 0);
    }

    public static void printPermutationHelper(char[] input, int level) {
        if (input.length - level < 1) {
            return;
        }

        if (input.length - level == 1) {
            Utils.printArrayln(input);
            return;
        }

        for (int i = level; i < input.length; i++) {
            Utils.swap(input, level, i);
            printPermutationHelper(input, level + 1);
            Utils.swap(input, level, i);
        }
    }

    
    public static void main(String[] argv) {
        String a = "aeiou";
        printPermutation(a);
    }

}
