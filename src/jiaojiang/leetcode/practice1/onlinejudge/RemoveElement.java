package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: mizhang@akamai.com
 */
public class RemoveElement {
    /*
    Given an array and a value, remove all instances of that value in place and return the new length.

    The order of elements can be changed. It doesn't matter what you leave beyond the new length.
     */
    public static int removeElement(int[] A, int elem) {
        int j = A.length - 1;
        while (j >= 0 && A[j] == elem) {
            j--;
        }

        for (int i = 0; i < j; i++) {
            if (A[i] == elem) {
                A[i] = A[j--];
                while (j > i && A[j] == elem) {
                    j--;
                }
            }
        }

        return j + 1;
    }

//test cases:
//[], 0	[]	[]
//
//[], 1 []
//
//[1], 1 []
//
//[2], 3 [2]
//
//[3,3], 3 []
//
//[3,3], 5 [3,3]
//
//[4,5], 4 [5]
//
//[4,5], 5 [4]
//
//[4,5], 6[4,5]
//
//[2,2,2], 0	[2,2,2]
//
}
