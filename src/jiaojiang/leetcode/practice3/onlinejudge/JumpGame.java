package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: zhang
 * @date: Feb 28, 2015 9:26:25 PM
 */
public class JumpGame {
    /*
     Given an array of non-negative integers, you are initially positioned at the first index of the array.

    Each element in the array represents your maximum jump length at that position.

    Determine if you are able to reach the last index.

    For example:
    A = [2,3,1,1,4], return true.

    A = [3,2,1,0,4], return false.
     */
    public static boolean canJump(int[] A) {
        return canJump(A, 0);
    }

    private static boolean canJump(int[] A, int start) {
        if (start >= A.length  - 1) {
            return true;
        }

        for (int i = start + 1; i <= start + A[start]; i++) {
            if (canJump(A, i)) {
                return true;
            }
        }

        return false;
    }

    public static boolean canJumpDP(int[] A) {
        boolean[] dp = new boolean[A.length];
        dp[A.length - 1] = true;
        for (int i = A.length - 2; i >= 0; i--) {
            dp[i] = A[i] >= A.length - i - 1;
            for (int j = i + 1; !dp[i] && j <= i + A[i] ; dp[i] = dp[j], j++);
        }

        return dp[0];
    }

    public static boolean canJump2DP(int[] A) {
        int[] dp = new int[A.length];
        dp[A.length - 1] = 0;

        for (int i = A.length - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] + 1 > A[i] ? dp[i + 1] + 1 : 0;
        }

        return dp[0] == 0;
    }

    public static boolean canJump3DP(int[] A) {
        int dp = 0;
        for (int i = A.length - 2; i >= 0; i--) {
            dp = dp + 1 > A[i] ? dp + 1 : 0;
        }

        return dp == 0;
    }
}
