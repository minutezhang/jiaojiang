package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Mar 4, 2016
 */
public class NimGame {
    /*
    You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of
    you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the
    first turn to remove the stones.

    Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can
    win the game given the number of stones in the heap.

    For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you
    remove, the last stone will always be removed by your friend.

    Hint:
        If there are 5 stones in the heap, could you figure out a way to remove the stones such that you will always be
        the winner?
     */
    public static boolean canWinNim(int n) {
        if (n <= 3) {
            return true;
        }

        return !canWinNim(n - 1) || !canWinNim(n - 2) || !canWinNim(n - 3); 
    }

    public static boolean canWinNimDp(int n) {
        boolean[] canWin = new boolean[]{true, true, true};

        if (n <= 3) {
            return true;
        }

        for (int i = 3; i < n; i++) {
            canWin[i % 3] = !canWin[i % 3] || !canWin[(i - 1) % 3] || !canWin[(i - 2) % 3];
        }

        return canWin[(n - 1) % 3];
    }

    public static boolean canWinNim2(int n) {
        return (n & 3) != 0;
    }
}
