package companies.facebook.careercup;

import utils.Utils;

/**
 * @author: zhang
 * @since: Feb 5, 2014 6:22:23 PM
 */
public class ArithmeticProgression {
    /*
    Given the AP :- 1 3 7 9 11 13 find the missing value "which would be 5 here".

    Conditions :
    Get an user for the length of AP sequence and make sure user provides length is above 3.
    Get the input in a single line ex:- "1 3 5 7 9 11"
    Provide the solution in O(n) or less if you can.
     */
    public static int findMissInArithmeticProgression(int[] A) {
        int start = 0, end = A.length - 1, d = Math.min(A[1] - A[0], A[2] - A[1]);

        while (start < end) {
            int mid = (start + end) >>> 1;
            if (mid == start) {
                return A[start] + d;
            }
            
            if (A[mid] - A[start] > d * (mid - start)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return -1;
    }

    private static void test() {
        Utils.printTestln(findMissInArithmeticProgression(new int[]{1, 3, 5, 7, 9, 11, 15, 17, 19, 21, 23, 25, 27}), 13);
        Utils.printTestln(findMissInArithmeticProgression(new int[]{1, 3, 7, 9}), 5);
        Utils.printTestln(findMissInArithmeticProgression(new int[]{1, 5, 7, 9}), 3);
    }

    public static void main(String[] args) {
        test();
    }
}
