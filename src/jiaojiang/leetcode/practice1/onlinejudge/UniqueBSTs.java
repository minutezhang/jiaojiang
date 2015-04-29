package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: Apr 29, 2013 10:23:32 PM
 */
public class UniqueBSTs {
    /*
    Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

    For example,
    Given n = 3, there are a total of 5 unique BST's.

       1         3     3      2      1
        \       /     /      / \      \
         3     2     1      1   3      2
        /     /       \                 \
       2     1         2                 3
     */
    public static int numTrees(int n) {
        int[] num = new int[n];

        num[0] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i - 1; j++) {
                num[i] += num[j] * num[i - j - 2];
            }
            num[i] += 2 * num[i - 1];
        }

        return num[n - 1];
    }

    public static void test() {
        System.out.println(numTrees(3));  //5
    }

    public static void main(String[] args) {
        test();
    }
}
