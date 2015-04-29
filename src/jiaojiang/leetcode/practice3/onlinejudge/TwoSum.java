package jiaojiang.leetcode.practice3.onlinejudge;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: mizhang
 * @time: 2/2/15 3:15 PM
 */
public class TwoSum {
    /*
    Given an array of integers, find two numbers such that they add up to a specific target number.

    The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must
    be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

    You may assume that each input would have exactly one solution.

    Input: numbers={2, 7, 11, 15}, target=9
    Output: index1=1, index2=2
     */
    public static int[] twoSum(int[] numbers, int target) {
        int[] ret = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (ret[1] = 1; ret[1] <= numbers.length; ret[1]++) {
            if (map.containsKey(target - numbers[ret[1] - 1]) && (ret[0] = map.get(target - numbers[ret[1] - 1])) != ret[1]) {
                return ret;
            }

            map.put(numbers[ret[1] - 1], ret[1]);
        }

        return ret;
    }
}
