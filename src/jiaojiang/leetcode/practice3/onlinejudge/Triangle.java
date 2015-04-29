package jiaojiang.leetcode.practice3.onlinejudge;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mizhang
 * @time: 2/7/15 11:35 PM
 */
public class Triangle {
    /*
    Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

    For example, given the following triangle
    [
         [2],
        [3,4],
       [6,5,7],
      [4,1,8,3]
    ]
    The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

    Note:
    Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> sum = new ArrayList<Integer>(triangle.get(triangle.size() - 1));
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> path = triangle.get(i);
            for (int j = 0; j < path.size(); j++) {
                sum.set(j, path.get(j) + Math.min(sum.get(j), sum.get(j + 1)));
            }
        }

        return sum.get(0);
    }
}

