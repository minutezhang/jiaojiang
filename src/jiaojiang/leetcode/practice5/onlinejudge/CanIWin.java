package jiaojiang.leetcode.practice5.onlinejudge;

public class CanIWin {
    /**
     * In the "100 game" two players take turns adding, to a running total, any integer from 1 to 10. The player
     * who first causes the running total to reach or exceed 100 wins.
     * <p>
     * What if we change the game so that players cannot re-use integers?
     * <p>
     * For example, two players might take turns drawing from a common pool of numbers from 1 to 15 without
     * replacement until they reach a total >= 100.
     * <p>
     * Given two integers maxChoosableInteger and desiredTotal, return true if the first player to move can
     * force a win, otherwise, return false. Assume both players play optimally.
     * <p>
     * Example 1:
     * <p>
     * Input: maxChoosableInteger = 10, desiredTotal = 11
     * Output: false
     * Explanation:
     * No matter which integer the first player choose, the first player will lose.
     * The first player can choose an integer from 1 up to 10.
     * If the first player choose 1, the second player can only choose integers from 2 up to 10.
     * The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
     * Same with other integers chosen by the first player, the second player will always win.
     * <p>
     * Example 2:
     * <p>
     * Input: maxChoosableInteger = 10, desiredTotal = 0
     * Output: true
     * <p>
     * Example 3:
     * <p>
     * Input: maxChoosableInteger = 10, desiredTotal = 1
     * Output: true
     * <p>
     * Constraints:
     * <p>
     * 1 <= maxChoosableInteger <= 20
     * 0 <= desiredTotal <= 300
     */

    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal > (1 + maxChoosableInteger) * maxChoosableInteger / 2) {
            return false;
        }
        if (desiredTotal == (1 + maxChoosableInteger) * maxChoosableInteger / 2) {
            return (maxChoosableInteger & 1) == 1;
        }
        int length = 1 << maxChoosableInteger;
        Boolean[] flags = new Boolean[length];

        return canIWinMem(maxChoosableInteger, desiredTotal, 0, flags);
    }

    private static boolean canIWinMem(int maxChoosableInteger, int desiredTotal, int flag, Boolean[] flags) {
        if (flags[flag]!= null) {
            return flags[flag];
        }

        int maxInt;
        for (maxInt = maxChoosableInteger; maxInt > 0 && ((1 << (maxInt - 1)) & flag) > 0; --maxInt) ;
        if (maxInt >= desiredTotal) {
            return true;
        }

        for (int i = maxChoosableInteger; i > 0; --i) {
            int tmpFlag = flag;
            if ((1 << (i - 1) & tmpFlag) == 0) {
                tmpFlag |= 1 << (i - 1);
                if (!canIWinMem(maxChoosableInteger, desiredTotal - i, tmpFlag, flags)) {
                    flags[flag] = true;
                    return true;
                }
            }
        }

        flags[flag] = false;
        return false;
    }

    public static boolean canIWinRec(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal > (1 + maxChoosableInteger) * maxChoosableInteger / 2) {
            return false;
        }
        if (desiredTotal == (1 + maxChoosableInteger) * maxChoosableInteger / 2) {
            return (maxChoosableInteger & 1) == 1;
        }

        boolean[] isUsed = new boolean[maxChoosableInteger];
        return canIWinRec(isUsed, desiredTotal);
    }

    private static boolean canIWinRec(boolean[] isUsed, int desiredTotal) {
        int maxInt;
        for (maxInt = isUsed.length; maxInt > 0 && isUsed[maxInt - 1]; --maxInt) ;
        if (maxInt >= desiredTotal) {
            return true;
        }

        for (int i = isUsed.length; i > 0; --i) {
            if (!isUsed[i - 1]) {
                isUsed[i - 1] = true;
                boolean canWin = canIWinRec(isUsed, desiredTotal - i);
                isUsed[i - 1] = false;
                if (!canWin) {
                    return true;
                }
            }
        }
        return false;
    }
}