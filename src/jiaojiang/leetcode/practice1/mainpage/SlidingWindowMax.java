package jiaojiang.leetcode.practice1.mainpage;

/**
 * @author: zhang
 * @since: Aug 24, 2013 10:46:24 PM
 */
public class SlidingWindowMax {
    /*
    A long array A[] is given to you. There is a sliding window of size w which is moving from the very left of the array to the very right. You can only see the w numbers in the window. Each time the sliding window moves rightwards by one position. Following is an example:
    The array is [1 3 -1 -3 5 3 6 7], and w is 3.

    Window position                Max
    ---------------               -----
    [1  3  -1] -3  5  3  6  7       3
     1 [3  -1  -3] 5  3  6  7       3
     1  3 [-1  -3  5] 3  6  7       5
     1  3  -1 [-3  5  3] 6  7       5
     1  3  -1  -3 [5  3  6] 7       6
     1  3  -1  -3  5 [3  6  7]      7
    Input: A long array A[], and a window width w
    Output: An array B[], B[i] is the maximum value of from A[i] to A[i+w-1]
    Requirement: Find a good optimal way to get B[i]\
     */
    public static int[] slidingMax(int[] data, int w) {
        int[] ret = new int[data.length - w  + 1];
        int[] dq = new int[w]; //double queue
        int dqTail = 0;

        for (int i = 0; i < w - 1; i++) {
            while (dqTail > 0 && data[i] > dq[dqTail - 1]) {
                dqTail--;
            }
            dq[dqTail++] = data[i];
        }

        for (int i = w - 1; i < data.length; i++) {
            while (dqTail > 0 && data[i] > dq[(dqTail - 1)% w]) {
                dqTail--;
            }
            dq[dqTail++%w] = data[i];
            ret[i - w + 1] = dq[dqTail >= w ? dqTail % w : 0];
        }

        return ret;
    }
    

    public static void test() {
        for (int d : slidingMax(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)) {  // 3, 3, 5, 5, 6, 7
            System.out.print(d + "\t");
        }
        System.out.println("\n");

        for (int d : slidingMax(new int[]{1, 5, 10, -3, 5, 13, 6, 7}, 3)) { //10, 10, 10, 13, 13, 13
            System.out.print(d + "\t");
        }
        System.out.println("\n");

        for (int d : slidingMax(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 3)) { //3, 4, 5, 6, 7, 8
            System.out.print(d + "\t");
        }
        System.out.println("\n");

        for (int d : slidingMax(new int[]{8, 7, 6, 5, 4, 3, 2, 1}, 3)) { //8, 7, 6, 5, 4, 3
            System.out.print(d + "\t");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        test();
    }

}
