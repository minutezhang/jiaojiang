package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @time: 3/6/15 3:29 PM
 */
public class NextPermutation {
    /*
    Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

    If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

    The replacement must be in-place, do not allocate extra memory.

    Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
    1,2,3 → 1,3,2
    3,2,1 → 1,2,3
    1,1,5 → 1,5,1
     */
    public static void nextPermutation(int[] num) {
        int index, swapIndex;
        for (index = num.length - 2; index >= 0 && num[index] >= num[index + 1]; index--);

        if (index >= 0) {
            for (swapIndex = num.length - 1; swapIndex > index && num[swapIndex] <= num[index]; swapIndex--);
            swap(num, index, swapIndex);
        }

        swapArray(num, index + 1, num.length - 1);
    }

    private static void swap(int[] num, int i, int j) {
        num[i] ^= num[j];
        num[j] ^= num[i];
        num[i] ^= num[j];
    }
    private static void swapArray(int[] num, int start, int end) {
        for (; start < end; start++, end--) {
            swap(num, start, end);
        }
    }
}
