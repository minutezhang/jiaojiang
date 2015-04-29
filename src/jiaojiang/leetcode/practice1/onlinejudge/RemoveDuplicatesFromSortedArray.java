package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: Apr 14, 2013 1:32:55 AM
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
        if (A.length == 0) {
            return 0;
        }

        int length = 1, current = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] != current) {
                A[length] = A[i];
                current = A[i];
                length++;
            }
        }

        return length;
    }


//test cases:
//[]
//
//[1]
//
//[1,1]
//
//[1,2]
//
//[1,1,1]
//
//[1,2,2]
//
//[1,1,2]
//
//[1,2,3]
//
//[1,1,1,1]


}
