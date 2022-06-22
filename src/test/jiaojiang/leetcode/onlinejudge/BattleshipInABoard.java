package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Given an m x n matrix board where each cell is a battleship 'X' or empty '.', return the number of the battleships on board.
 * <p>
 * Battleships can only be placed horizontally or vertically on board. In other words, they can only be made of the shape 1 x k (1 row, k columns) or k x 1 (k rows, 1 column), where k can be of any size. At least one horizontal or vertical cell separates between two battleships (i.e., there are no adjacent battleships).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * X__X
 * ___X
 * ___X
 * ____
 * <p>
 * Input: board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: board = [["."]]
 * Output: 0
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] is either '.' or 'X'.
 * <p>
 * <p>
 * <p>
 * Follow up: Could you do it in one-pass, using only O(1) extra memory and without modifying the values board?
 */
public class BattleshipInABoard {

    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, char[][].class);

            Test.assertEquals(2,
                    (int) method.invoke(null, (Object)new char[][]{
                            {'X', '.', '.', 'X'},
                            {'.', '.', '.', 'X'},
                            {'.', '.', '.', 'X'},
                            {'.', '.', '.', '.'}}));
            Test.assertEquals(0, method.invoke(null, (Object)new char[][]{{'.'}}));
            Test.assertEquals(0, method.invoke(null, (Object)new char[][]{{'.','.','.','X',}, {'X','X','X','X',}, {'.','.','.','X'}}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
