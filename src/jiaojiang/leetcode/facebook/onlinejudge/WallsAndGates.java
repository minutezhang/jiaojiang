package jiaojiang.leetcode.facebook.onlinejudge;

import java.util.Queue;
import java.util.LinkedList;

/**
 * @author zhang
 *
 * Created on Sep 5, 2016
 */
public class WallsAndGates {
    /*
    You are given a m x n 2D grid initialized with these three possible values.

    1. -1 - A wall or an obstacle.
    2. 0 - A gate.
    3. INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may
    assume that the distance to a gate is less than 2147483647.

    Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should
    be filled with INF.
    For example, given the 2D grid:

    INF  -1  0  INF
    INF INF INF  -1
    INF  -1 INF  -1
    0  -1 INF INF

    After running your function, the 2D grid should be:

    3  -1   0   1
    2   2   1  -1
    1  -1   2  -1
    0  -1   3   4
     */
    public static void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    wallsAndGates(rooms, i, j, 0);
                }
            }
        }
    }

    private static void wallsAndGates(int[][] rooms, int i, int j, int distance) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < distance) {
            return;
        }

        rooms[i][j] = distance;
        wallsAndGates(rooms, i - 1, j, distance + 1);
        wallsAndGates(rooms, i + 1, j, distance + 1);
        wallsAndGates(rooms, i, j - 1, distance + 1);
        wallsAndGates(rooms, i, j + 1, distance + 1);
    }
}
