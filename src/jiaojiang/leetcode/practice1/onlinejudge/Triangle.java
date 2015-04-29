package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.ArrayList;

/**
 * @author: zhang
 * @since: Apr 24, 2013 11:19:29 PM
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
    Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle
     */

    //solution: bottum up
    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            ArrayList<Integer> line = triangle.get(i);
            for (int j = 0; j < line.size(); j++) {
                line.set(j, line.get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }

        return triangle.get(0).get(0);
    }

    public static ArrayList<ArrayList<Integer>> getTriangle() {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> line = new ArrayList<Integer>();
        line.add(2);
        triangle.add(line);

        line = new ArrayList<Integer>();
        line.add(3);
        line.add(4);
        triangle.add(line);

        line = new ArrayList<Integer>();
        line.add(6);
        line.add(5);
        line.add(7);
        triangle.add(line);

        line = new ArrayList<Integer>();
        line.add(4);
        line.add(1);
        line.add(8);
        line.add(3);
        triangle.add(line);
        
        return triangle;
    }

    public static void test() {
        System.out.println(minimumTotal(getTriangle()));
    }

    public static void main(String[] args) {
        test();
    }

}
