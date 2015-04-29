package jiaojiang.leetcode.practice3.onlinejudge;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mizhang
 * @time: 2/12/15 11:01 AM
 */
public class PascalsTriangle {
    /*
    Given numRows, generate the first numRows of Pascal's triangle.

    For example, given numRows = 5,
    Return

    [
         [1],
        [1,1],
       [1,2,1],
      [1,3,3,1],
     [1,4,6,4,1]
    ]
    */

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> seed = new ArrayList<Integer>();

        if (numRows == 0) {
            return ret;
        }

        seed.add(1);
        ret.add(seed);

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<Integer>(seed);
            row.add(1);
            List<Integer> preRow = ret.get(ret.size() - 1);
            for (int j = preRow.size() - 1; j > 0; j--) {
                row.add(1, preRow.get(j) + preRow.get(j - 1));
            }
            ret.add(row);
        }

        return ret;
    }
}