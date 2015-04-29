package jiaojiang.leetcode.practice3.onlinejudge;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: mizhang
 * @time: 2/12/15 2:32 PM
 */
public class MajorityElement {
    /*
    Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

    You may assume that the array is non-empty and the majority element always exist in the array.

    Credits:
    Special thanks to @ts for adding this problem and creating all test cases.
     */
    public static int majorityElement(int[] num) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();

        for (int i  : num) {
            if (!counts.containsKey(i)) {
                counts.put(i, 0);

            }
            int count = counts.get(i) + 1;
            if (count > num.length / 2) {
                return i;
            }
            counts.put(i, count);
        }

        return 0;
    }

    public static int majorityElement2(int[] num) {
        int start, index, length = num.length;

        while (length > 1) {
            for (start = 0, index = 0; index < length; index += 2) {
                if (index + 1 < length) {
                    if (num[index] == num[index + 1]) {
                        num[start] = num[index];
                        start++;
                    }
                } else {
                    num[start] = num[index];
                    start++;
                }
            }
            length = start;
        }

        return num[0];
    }
}
