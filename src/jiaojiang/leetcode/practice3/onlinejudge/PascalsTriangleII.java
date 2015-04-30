package jiaojiang.leetcode.practice3.onlinejudge;

import java.util.List;
import java.util.ArrayList;

/**
 * @author: zhang
 * @date: Apr 29, 2015 10:44:51 PM
 */
public class PascalsTriangleII {
    /*
    Given an index k, return the kth row of the Pascal's triangle.

    For example, given k = 3,
    Return [1,3,3,1].

    Note:
    Could you optimize your algorithm to use only O(k) extra space?
     */
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<Integer>();

        for (int i = 0; i <= rowIndex; i++) {
            for (int j = 0; j < ret.size() - 1; j++) {
                ret.set(j, ret.get(j) + ret.get(j + 1));
            }
            ret.add(0, 1);
        }

        return ret;
    }
}
