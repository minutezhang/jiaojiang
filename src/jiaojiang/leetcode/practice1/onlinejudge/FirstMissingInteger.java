package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: May 19, 2013 9:18:20 PM
 */
public class FirstMissingInteger {
    /*
    Given an unsorted integer array, find the first missing positive integer.

     For example,
     Given [1,2,0] return 3,
     and [3,4,-1,1] return 2.

     Your algorithm should run in O(n) time and uses constant space.
     */
    public static int firstMissingPositive(int[] A) {
        for (int i = 0; i < A.length; i++) {
            int n = A[i];
            while ( n > 0 && n <= A.length && A[n - 1] != n) {
                int tmp = A[n - 1];
                A[n - 1] = n;
                n = tmp;
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return A.length + 1;
    }

    public static void test() {
        System.out.println(firstMissingPositive(new int[]{1, 2, 0})); //3
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1})); //2
    }

    public static void main(String[] args){
        test();
    }

}
