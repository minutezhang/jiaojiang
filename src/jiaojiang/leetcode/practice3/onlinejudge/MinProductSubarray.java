package jiaojiang.leetcode.practice3.onlinejudge;

import utils.Test;

/**
 * @author: mizhang
 * @since: Nov 30, 2014 3:20:35 PM
 */
public class MinProductSubarray {
    /*
    Find the contiguous subarray within an array (containing at least one number) which has the largest product.

    For example, given the array [2,3,-2,4],
    the contiguous subarray [2,3] has the largest product = 6.
     */
    //assume no zero element
    public static int maxProductNoZero(int[] A, int startIndex, int endIndex) {
        if (endIndex == startIndex ) {
            return 0;
        }
        
        if (endIndex - startIndex == 1) {
            return A[startIndex];
        }

        int start, end, leftProd = 1, rightProd = 1, prod = 1, maxProd = 0;

        for (start = startIndex; start < endIndex && A[start] > 0; leftProd *= A[start], start++);
        if (start >= endIndex - 1) {
            return leftProd;
        }

        for (end = endIndex - 1; end > start && A[end] > 0; rightProd *= A[end], end--);
        if (start == end) {
            return Math.max(leftProd, rightProd);
        }

        for (int i = start + 1; i < end; prod *= A[i], i++);
        if (prod < 0) {
            return Math.max(leftProd * A[start] * prod, rightProd * A[end] * prod);
        }

        return prod * A[start] * leftProd * A[end] * rightProd;
    }

    public static int maxProduct(int[] A, int startIndex, int endIndex) {
        int i;
        for (i = startIndex; i < endIndex && A[i] != 0; i++);
        if (i == endIndex) {
            return maxProductNoZero(A, startIndex, endIndex);
        }

        return Math.max(maxProductNoZero(A, startIndex, i), Math.max(0, maxProduct(A, i + 1, endIndex)));
    }

    public static int maxProduct(int[] A) {
        return maxProduct(A, 0, A.length);
    }

    public static void test() {
        Test.assertEquals(maxProduct(new int[]{2, 3, -2, 4}), 6);
        Test.assertEquals(maxProduct(new int[]{-2}), -2);
        Test.assertEquals(maxProduct(new int[]{-2, 4}), 4);
        Test.assertEquals(maxProduct(new int[]{-5, 0, 2}), 2);
        Test.assertEquals(maxProduct(new int[]{0}), 0);
        Test.assertEquals(maxProduct(new int[]{-2, 0, -1}), 0);
    }

    public static int maxProduct2(int[] A) {
        int maxProd = A[0], minProd = A[0], ret = A[0];

        for (int i = 1; i < A.length; i++) {
            int newMaxProd = Math.max(A[i], Math.max(A[i] * maxProd, A[i] * minProd));
            minProd = Math.min(A[i], Math.min(A[i] * maxProd, A[i] * minProd));
            maxProd = newMaxProd;
            ret = Math.max(maxProd,  ret);
        }

        return ret;
    }


    public static void test2() {
        Test.assertEquals(maxProduct2(new int[]{2, 3, -2, 4}), 6);
        Test.assertEquals(maxProduct2(new int[]{-2}), -2);
        Test.assertEquals(maxProduct2(new int[]{-2, 4}), 4);
        Test.assertEquals(maxProduct2(new int[]{-5, 0, 2}), 2);
        Test.assertEquals(maxProduct2(new int[]{0}), 0);
        Test.assertEquals(maxProduct2(new int[]{-2, 0, -1}), 0);
    }

    public static void main(String[] args) {
        test();
        System.out.println();
        test2();
    }

    /*
    Besides keeping track of the largest product, we also need to keep track of the smallest product. Why? The smallest
    product, which is the largest in the negative sense could become the maximum when being multiplied by a negative number.

    Let us denote that:

    f(k) = Largest product subarray, from index 0 up to k.
    Similarly,

    g(k) = Smallest product subarray, from index 0 up to k.
    Then,

    f(k) = max( f(k-1) * A[k], A[k], g(k-1) * A[k] )
    g(k) = min( g(k-1) * A[k], A[k], f(k-1) * A[k] )
    There we have a dynamic programming formula. Using two arrays of size n, we could deduce the final answer as f(n-1).
    Since we only need to access its previous elements at each step, two variables are sufficient.
     */
}
