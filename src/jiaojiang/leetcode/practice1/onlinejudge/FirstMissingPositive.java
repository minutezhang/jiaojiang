package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: mizhang@akamai.com
 */
public class FirstMissingPositive {

    // Get the first missing positive number
    public static int firstMissingPositive(int[] A) {

        int index;

        for (int i = 0; i < A.length; i++) {
            index  = A[i];
            while (index > 0 && index <= A.length && index != A[index - 1]) {
                int tmp = A[index - 1];
                A[index - 1] = index;
                index = tmp;
            }
        }

        for (index = 0; index < A.length && A[index] == index + 1; index++);

        return index + 1;
    }

    public static void main(String[] args) {
        int[][] integers = new int[][] {{4, 5, 3, 2, 7, 6}, {1, 4, 3, 5, 6, 7}, {3, 2, 4, 1, 6, 5}};
        for (int[] is: integers) {
            System.out.println(firstMissingPositive(is));
        }
    }
}
