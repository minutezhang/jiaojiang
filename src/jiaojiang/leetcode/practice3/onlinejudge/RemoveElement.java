package jiaojiang.leetcode.practice3.onlinejudge;

import utils.Test;

/**
 * @author: mizhang
 * @since: Dec 12, 2014 5:13:18 PM
 */
public class RemoveElement {
    /*
    Given an array and a value, remove all instances of that value in place and return the new length.

    The order of elements can be changed. It doesn't matter what you leave beyond the new length.
     */
    public static int removeElement(int[] A, int elem) {
        int writeIndex = 0;
        for (int index = 0; index < A.length; index++) {
            if (A[index] != elem) {
                if (index != writeIndex) {
                    A[writeIndex] = A[index];
                }
                writeIndex++;
            }
        }

        return writeIndex;
    }

    public static void test() {
        int[] A = new int[]{1, 2, 6, 10, 9, 8, 10 , 11};
        int length = removeElement(A, 10);
        Test.assertEquals(6, length);
        Test.printArrayWithRange(A, length);
    }

    public static void main(String[] args) {
        test();
    }
}
