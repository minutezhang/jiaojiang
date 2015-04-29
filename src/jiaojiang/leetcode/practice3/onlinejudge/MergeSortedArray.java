package jiaojiang.leetcode.practice3.onlinejudge;

import utils.Test;

/**
 * User: Zhang
 * Date: Dec 11, 2014
 */
public class MergeSortedArray {
    /*
    Given two sorted integer arrays A and B, merge B into A as one sorted array.

    Note:
    You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B.
    The number of elements initialized in A and B are m and n respectively.
     */
    public static void merge(int A[], int m, int B[], int n) {
        int i, j;
        for (i = m - 1, j = n - 1; i >= 0 && j >= 0; A[i + j + 1] = A[i] > B[j] ? A[i--] : B[j--]);
        for (; j >= 0; A[j] = B[j], j--);
    }

    public static void test() {
        int[] A = new int[]{1, 3, 5, 7, 9, 0, 0, 0, 0, 0, 0, 0, 0};
        merge(A, 5, new int[]{2, 4, 6, 8, 10}, 5);

        Test.printArrayWithRange(A, 10);
    }

    public static void main(String[] args) {
        test();
    }
}
