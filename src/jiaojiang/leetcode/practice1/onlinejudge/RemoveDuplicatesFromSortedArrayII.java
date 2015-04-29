package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: mizhang@akamai.com
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
        if (A.length == 0) {
            return 0;
        }

        int i = 1, j = 1, count = 1, current = A[0];

        for ( ; i < A.length; i++) {
            if (A[i] == current) {
                count++;
            } else {
                current = A[i];
                count = 1;
            }

            A[j] = A[i];

            if (count <= 2) {
                j++;
            }
        }

        return j;
    }

    public static void test() {
        int[] A = {1, 1, 1, 2, 2, 3};
        for (int i = 0, n = removeDuplicates(A); i < n; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        test();
    }
}
