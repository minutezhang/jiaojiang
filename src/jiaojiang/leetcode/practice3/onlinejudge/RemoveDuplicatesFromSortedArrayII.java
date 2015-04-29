package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @time: 1/28/15 10:41 AM
 */
public class RemoveDuplicatesFromSortedArrayII {
    /*
    Follow up for "Remove Duplicates":
    What if duplicates are allowed at most twice?

    For example,
    Given sorted array A = [1,1,1,2,2,3],

    Your function should return length = 5, and A is now [1,1,2,2,3].
     */
    public static int removeDuplicates(int[] A) {
        int writeIndex = 1, count = 1;
        for (int readIndex = 1; readIndex < A.length; readIndex++) {
            if (A[readIndex] != A[readIndex - 1]) {
                A[writeIndex++] = A[readIndex];
                count = 1;
            } else if (count < 2) {
                A[writeIndex++] = A[readIndex];
                count++;
            }
        }

        return A.length == 0 ? 0 : writeIndex;
    }
}
