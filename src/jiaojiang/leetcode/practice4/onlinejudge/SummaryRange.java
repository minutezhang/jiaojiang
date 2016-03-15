package jiaojiang.leetcode.practice4.onlinejudge;

import java.util.List;
import java.util.ArrayList;

/**
 * @author zhang
 *
 * Created on Mar 14, 2016
 */
public class SummaryRange {
    /*
     Given a sorted integer array without duplicates, return the summary of its ranges.

    For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
     */
    public static List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<String>();
        if (nums.length == 0) {
            return ret;
        }

        int start = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (sb.length() == 0) {
                sb.append(start = nums[i]);
            } else if (nums[i] - 1 > nums[i - 1]) {
                if (nums[i - 1] > start) {
                    sb.append("->")
                            .append(nums[i - 1]);
                }
                ret.add(sb.toString());
                sb.setLength(0);
                sb.append(start = nums[i]);
            }
        }

        if (nums[nums.length - 1] > start) {
            sb.append("->")
                    .append(nums[nums.length - 1]);
        }
        ret.add(sb.toString());
        return ret;
    }
}
