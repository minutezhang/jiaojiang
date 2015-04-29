package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @time: 2/26/15 4:51 PM
 */
public class MaximumProductSubarray {
    /*
    Find the contiguous subarray within an array (containing at least one number) which has the largest product.

    For example, given the array [2,3,-2,4],
    the contiguous subarray [2,3] has the largest product = 6.
     */
    public static int maxProduct(int[] A) {
        int minProd = A[0], maxProd = A[0], max = A[0];
        for (int i = 1; i < A.length; i++) {
            int curentMaxProd = Math.max(minProd * A[i], Math.max(maxProd * A[i], A[i]));
            int currentMinProd = Math.min(maxProd * A[i], Math.min(minProd * A[i], A[i]));
            max = Math.max(max, curentMaxProd);
            maxProd = curentMaxProd;
            minProd = currentMinProd;
        }

        return max;
    }
}
