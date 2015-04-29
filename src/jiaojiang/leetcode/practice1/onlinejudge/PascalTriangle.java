package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.ArrayList;

/**
 * @author: zhang
 * @since: Apr 25, 2013 11:43:16 PM
 */
public class PascalTriangle {
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
    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

        if (numRows == 0) {
            return ret;
        }

        ArrayList<Integer> line = new ArrayList<Integer>();
        line.add(1);
        ret.add(line);

        int i = 1;
        while (i < numRows) {
            ArrayList<Integer> newLine = new ArrayList<Integer>();
            line = ret.get(i - 1);
            newLine.add(line.get(0));
            for (int j = 0; j < line.size() - 1; j++) {
                newLine.add(line.get(j) + line.get(j + 1));
            }
            newLine.add(line.get(line.size() - 1));
            i++;
            ret.add(newLine);
        }
        
        return ret;
    }
}
