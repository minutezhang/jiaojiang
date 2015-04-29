package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: May 20, 2013 4:20:50 PM
 */
public class NQueensII {
    /*
    Follow up for N-Queens problem.

    Now, instead outputting board configurations, return the total number of distinct solutions.
     */
    public static int totalNQueens(int n) {
        return totalNQueens(new int[n], 0, n);
    }

    public static int totalNQueens(int[] indices, int level, int n) {
        if (level == n) {
            return 1;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isOK(indices, level, i)) {
                indices[level]= i;
                count += totalNQueens(indices, level + 1, n);
            }
        }
        
        return count;
    }

    public static boolean isOK(int[] indices, int level, int index) {
        for (int i = 0; i < level; i++) {
            if (indices[i] == index || level - i == index - indices[i] || i - level == index - indices[i]) {
                return false;
            }
        }

        return true;
    }

    public static void test() {
        System.out.println(totalNQueens(1)); //1
        System.out.println(totalNQueens(2)); //0
        System.out.println(totalNQueens(3)); //0
        System.out.println(totalNQueens(4)); //2
        System.out.println(totalNQueens(5)); //10
        System.out.println(totalNQueens(6)); //4
        System.out.println(totalNQueens(7)); //40
        System.out.println(totalNQueens(8)); //92
    }

    public static void main(String[] args) {
        test();
    }
}
