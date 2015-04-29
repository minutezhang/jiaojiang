package jiaojiang.leetcode.practice1.mainpage;

/**
 * @author: zhang
 */
public class MaxDistance {

    /*
    Given an array A of integers, find the maximum of j-i subjected to the constraint of A[i] < A[j].
     */
    public static int maxDistance(int[] data) {
        int[] leftMin = new int[data.length];
        int[] rightMax = new int[data.length];
        leftMin[0] = data[0];
        rightMax[data.length - 1] = data[data.length - 1];


        for (int i = 1; i < data.length; i++) {
            leftMin[i] = Math.min(data[i], leftMin[i - 1]);
            rightMax[data.length - i - 1] = Math.max(data[data.length - i - 1], rightMax[data.length - i]);
        }

        int max = -1, i = data.length - 1, j = data.length - 1;

        while (i >= 0 && j >= 0) {
            while (j >= 0 && rightMax[j] <= leftMin[i]) {
                j--;
            }
            while (i >= 0 && j >= 0 && rightMax[j] > leftMin[i]) {
                i--;
            }
            max = Math.max(max, j - i - 1);
        }

        return max;
    }

    public static void test() {
        System.out.println(maxDistance(new int[]{4, 3, 5, 2, 1, 3, 2, 3}));    //4
        System.out.println(maxDistance(new int[]{4, 1, 5, 2, 1, 3, 2, 3}));    //6
        System.out.println(maxDistance(new int[]{1, 4, 5, 2, 1, 3, 2, 3}));    //7
        System.out.println(maxDistance(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));    //7
        System.out.println(maxDistance(new int[]{8, 7, 6, 5, 4, 3, 2, 1}));    //-1
    }

    public static void main(String[] args) {
        test();
    }
}
