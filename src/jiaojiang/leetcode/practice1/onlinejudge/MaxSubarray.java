package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: Apr 30, 2013 9:59:05 PM
 */
public class MaxSubarray {
    /*
    Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

    For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
    the contiguous subarray [4,-1,2,1] has the largest sum = 6.
    */
    public static int maxSubarray(int[] A) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i : A) {
            sum += i;
            max = Math.max(sum, max);
            sum = Math.max(sum, 0);
        }

        return max;
    }

    public static void test() {
        System.out.println(maxSubarray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));    //6
    }

    public static void main(String[] args) {
        test();
    }
}
