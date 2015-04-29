package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mizhang@akamai.com
 */
public class JumpGameII {
    /*
    Given an array of non-negative integers, you are initially positioned at the first index of the array.

    Each element in the array represents your maximum jump length at that position.

    Your goal is to reach the last index in the minimum number of jumps.

    For example:
    Given array A = [2,3,1,1,4]

    The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
     */

    public static int jump(int[] A) {
        return jump(A, 0);
    }

    public static int jump(int[] A, int index) {
        if (index >= A.length - 1) {
            return 0;
        }

        if (A[index] == 0) {
            return -1;
        }

        int minJump = Integer.MAX_VALUE - 1;

        for (int i = A[index]; i > 0; i--) {
            int jump = jump(A, index + i);
            if (jump < minJump && jump != -1) {
                minJump = jump;
            }
        }

        return minJump + 1;
    }

    public static int jumpDP(int[] A) {
        if (A.length <= 1) {
            return 0;
        }

        List<Integer> zero = new ArrayList<Integer>();
        List<Integer> current = new ArrayList<Integer>();

        for (int i = 0; i < A.length - 1; i++) {
            if(A[i] + i >= A.length - 1) {
                current.add(i);
            } else {
                zero.add(i);
            }
        }

        int nJump = 1;
        while (!zero.isEmpty() && zero.get(0) == 0) {
            List<Integer> newIndex  = new ArrayList<Integer>();
            for (int i : current) {
                for (int j = zero.size() - 1; j >= 0; j--) {
                    if (A[zero.get(j)] + zero.get(j) >= i) {
                        newIndex.add(zero.get(j));
                        zero.remove(j);
                    }
                }
            }
            current = newIndex;
            nJump++;
        }

        return nJump;
    }

    public static void test() {
        System.out.println(jump(new int[]{1})); // 2
        System.out.println(jump(new int[]{2,3,1,1,4})); // 2
        System.out.println(jump(new int[]{3,4,3,1,0,7,0,3,0,2,0,3})); // 3
        System.out.println(jumpDP(new int[]{1})); // 2
        System.out.println(jumpDP(new int[]{2,3,1,1,4})); // 2
        System.out.println(jumpDP(new int[]{3, 4, 3, 1, 0, 7, 0, 3, 0, 2, 0, 3})); // 3
    }

    public static void main(String[] args) {
        test();
    }
}
