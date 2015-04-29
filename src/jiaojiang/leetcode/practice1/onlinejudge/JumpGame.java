package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: May 1, 2013 12:12:52 AM
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

    public static boolean canJump(int[] A, int index) {
        if (index >= A.length - 1) {
            return true;
        }

        if (A[index] == 0) {
            return false;
        }

        for (int i = A[index]; i > 0 ; i--) {
            if (canJump(A, index + i)) {
                return true;
            }
        }

        return false;
    }

    public static boolean canJumpDP(int[] A) {
        if (A.length == 0 || A.length == 1) {
            return true;
        }

        boolean[] canJump = new boolean[A.length - 1];
        int closestIndex = A.length - 1;

        for (int i = A.length - 2; i >= 0; i--) {
            if (closestIndex - i <= A[i]) {
                canJump[i] = true;
                closestIndex = i;
            }
        }

        return canJump[0];
    }

    public static void test() {
        System.out.println(canJump(new int[]{2,3,1,1,4})); // true
        System.out.println(canJump(new int[]{3,2,1,0,4})); // false

        System.out.println(canJumpDP(new int[]{2,3,1,1,4})); // true
        System.out.println(canJumpDP(new int[]{3,2,1,0,4})); // false
    }

    public static void main(String[] args) {
        test();
    }
}
