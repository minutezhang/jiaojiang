package jiaojiang.leetcode.practice4.onlinejudge;

import java.util.List;
import java.util.ArrayList;

/**
 * @author zhang
 *
 * Created on Mar 20, 2016
 */
public class UglyNumberII {
    /*
 Write a program to find the n-th ugly number.

    Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9,
    10, 12 is the sequence of the first 10 ugly numbers.

    Note that 1 is typically treated as an ugly number.

    Hint:

        The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly.
        Try to focus your effort on generating only the ugly ones.
        An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
        The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted
        lists: L1, L2, and L3.
        Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).


    Note:
        (1) 1?2, 2?2, 3?2, 4?2, 5?2, É
        (2) 1?3, 2?3, 3?3, 4?3, 5?3, É
        (3) 1?5, 2?5, 3?5, 4?5, 5?5, É
     */

    public static int nthUglyNumber(int n) {
        List<Integer> queue = new ArrayList<Integer>();
        int i2 = 0, i3 = 0, i5 = 0;
        queue.add(1);

        for (int i = 1; i < n; i++) {
            int v2 = queue.get(i2) * 2, v3 = queue.get(i3) * 3, v5 = queue.get(i5) * 5;
            int min = Math.min(Math.min(v2, v3), v5);
            queue.add(min);

            if (min == v2) {
                i2++;
            }

            if (min == v3) {
                i3++;
            }

            if (min == v5) {
                i5++;
            }
        }

        return queue.get(queue.size() - 1);
    }
}
