package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.Set;
import java.util.HashSet;

/**
 * @author: zhang
 * @since: Apr 19, 2013 10:20:22 PM
 */
public class LongestConsecutiveSequence {
    /*
    Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

    For example,
    Given [100, 4, 200, 1, 3, 2],
    The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

    Your algorithm should run in O(n) complexity.
     */
    public static int longestConsecutive(int[] num) {
        Set<Integer> numbers = new HashSet<Integer>();
        for (int i : num) {
            numbers.add(i);
        }

        int max = 0;
        for (int i : num) {
            if (numbers.contains(i)) {
                numbers.remove(i);
                int left = i, right = i;
                while (numbers.contains(--left)) {
                    numbers.remove(left);
                }
                while (numbers.contains(++right)) {
                    numbers.remove(right);
                }
                max = right - left - 1 > max ? right - left - 1 : max;
            }
        }

        return max;
    }

    public static void test() {
        System.out.println(longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
    }

    public static void main(String[] args) {
        test();
    }
}
