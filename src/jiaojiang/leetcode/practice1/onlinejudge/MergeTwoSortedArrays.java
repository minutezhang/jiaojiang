package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: Apr 14, 2013 11:55:57 PM
 */
public class MergeTwoSortedArrays {
    /*
     Given two sorted integer arrays A and B, merge B into A as one sorted array.

    Note:
    You may assume that A has enough space to hold additional elements from B. The number of elements initialized
    in A and B are m and n respectively.
     */

    //You may assume that A has enough space to hold additional
    // elements from B. The number of elements initialized in
    // A and B are m and n respectively.
    public static void merge(int A[], int m, int B[], int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (A[i] <= B[j]) {
                A[k--] = B[j--];
            } else {
                A[k--] = A[i--];
            }
        }

        if (i < 0) {
            System.arraycopy(B, 0, A, 0, j + 1);
        }
    }
//test cases
//[1], []	[1]
//
//[], [1]	[1]
//
//[1], [2]	[1,2]
//
//[2], [1]	[1,2]
//
//[1,2,3], [2,5,6]	[1,2,2,3,5,6]
//
//[1,2,3], [4,5,6]	[1,2,3,4,5,6]
//
//[4,5,6], [1,2,3]	[1,2,3,4,5,6]
//
//[], [1,2,3,4,5]	[1,2,3,4,5]
//
//[1,2,3,4,5], []	[1,2,3,4,5]
}
