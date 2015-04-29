package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: zhang
 * @date: Feb 28, 2015 9:37:37 AM
 */
public class FindMissingPositive {
    /*
     Given an unsorted integer array, find the first missing positive integer.

    For example,
    Given [1,2,0] return 3,
    and [3,4,-1,1] return 2.

    Your algorithm should run in O(n) time and uses constant space.
     */
    public static int firstMissingPositive(int[] A) {
        for (int i = 0; i < A.length; ) {
            if (A[i]  > 0 && A[i] <= A.length && A[i] != i + 1 && A[A[i] - 1] != A[i]) {
                swap(A, A[i] - 1, i);
            } else {
                i++;
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }

        return A.length + 1;
    }

    private static void swap(int[] A, int i, int j) {
        if (i != j) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }
}
