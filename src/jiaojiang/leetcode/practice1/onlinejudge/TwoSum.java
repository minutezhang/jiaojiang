package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: mizhang@akamai.com
 */
public class TwoSum {
    /*
    Given an array of integers, find two numbers such that they add up to a specific target number.

    The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

    You may assume that each input would have exactly one solution.

    Input: numbers={2, 7, 11, 15}, target=9
    Output: index1=1, index2=2
     */
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> hasNumber = new HashMap<Integer, Integer>();

        for (int i : numbers) {
            if (!hasNumber.containsKey(i)) {
                hasNumber.put(i, 1);
            } else {
                hasNumber.put(i, hasNumber.get(i) + 1);
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            int m = target - numbers[i];
            if (hasNumber.containsKey(m)) {
                if (m == numbers[i] && hasNumber.get(numbers[i]) > 1 || m != numbers[i]) {
                    int j = i + 1;
                    for (; j < numbers.length && numbers[j] != m; j++);
                    return new int[] {i + 1, j + 1};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] numbers  = new int[]{2,1,9,4,4,56,90,3};
        int[] indices = twoSum(numbers, 8);
        System.out.println(indices[0] + " : " + indices[1]);
    }
}
