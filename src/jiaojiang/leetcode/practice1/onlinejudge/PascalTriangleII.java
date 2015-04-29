package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.ArrayList;

/**
 * @author: zhang
 * @since: Apr 25, 2013 11:54:37 PM
 */
public class PascalTriangleII {
    /*
    Given an index k, return the kth row of the Pascal's triangle.

    For example, given k = 3,
    Return [1,3,3,1].

    Note:
    Could you optimize your algorithm to use only O(k) extra space?
     */
    public static ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> triangle = new ArrayList<Integer>();

        triangle.add(1);

        int i = 1;
        while (i <= rowIndex) {
            triangle.add(triangle.get(i - 1));
            int pre = triangle.get(0);
            for (int j = 1; j < i; j++) {
                int post = triangle.get(j);
                triangle.set(j, pre + triangle.get(j));
                pre = post;
            }
            i++;
        }

        return triangle;
    }

    public static void test() {
        for (int i : getRow(5)) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        test();
    }
}
