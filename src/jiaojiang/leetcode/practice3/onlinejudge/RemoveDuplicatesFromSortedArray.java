package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @time: 1/28/15 10:59 AM
 */
public class RemoveDuplicatesFromSortedArray {
    /*
    Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

    Do not allocate extra space for another array, you must do this in place with constant memory.

    For example,
    Given input array A = [1,1,2],

    Your function should return length = 2, and A is now [1,2].
     */
    public static int removeDuplicates(int[] A) {
        int writeIndex = 1;
        for(int readIndex = 1; readIndex < A.length; readIndex++) {
            if (A[readIndex] != A[readIndex - 1]) {
                A[writeIndex++] = A[readIndex];
            }
        }
        return A.length == 0 ? 0 : writeIndex;
    }
}
