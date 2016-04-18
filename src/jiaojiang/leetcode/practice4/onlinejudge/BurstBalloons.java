package jiaojiang.leetcode.practice4.onlinejudge;

import utils.Utils;

import java.util.List;
import java.util.ArrayList;

/**
 * @author zhang
 *
 * Created on Apr 4, 2016
 */
public class BurstBalloons {
    /*
    Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums.
    You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right]
    coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

    Find the maximum coins you can collect by bursting the balloons wisely.

    Note:
    (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
    (2) 0 ² n ² 500, 0 ² nums[i] ² 100

    Example:

    Given [3, 1, 5, 8]

    Return 167

        nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
       coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
     */
   
    public static int maxCoins(int[] nums) {
        List<Integer> numList = new ArrayList<Integer>();
        numList.add(1);
        for (int i : nums) {
            numList.add(i);
        }
        numList.add(1);

        return maxCoins(numList);
    }


    private static int maxCoins(List<Integer> nums) {
        if (nums.size() == 3) {
            return nums.get(1);
        }

        int max = 0;
        for (int i = 1; i < nums.size() - 1; i++) {
            int num = nums.remove(i);
            max = Math.max(nums.get(i - 1) * num * nums.get(i) + maxCoins(nums), max);
            nums.add(i, num);
        }

        return max;
    }


    public static int maxCoins2(int[] nums) {
        int[] newNums = new int[nums.length + 2];
        
        System.arraycopy(nums, 0, newNums, 1, nums.length);
        newNums[0] = newNums[newNums.length - 1] = 1;

        return maxCoins2(newNums, 0, newNums.length - 1);
    }

    private static int maxCoins2(int[] nums, int left, int right) {
        if (left + 1 >= right) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for (int i = left + 1; i < right; i++) {
            max = Math.max(max, nums[left] * nums[i] * nums[right] + maxCoins2(nums, left, i) + maxCoins2(nums, i, right));
        }

        return max;
    }

    public static int maxCoins2Mem(int[] nums) {
        int[] newNums = new int[nums.length + 2];

        System.arraycopy(nums, 0, newNums, 1, nums.length);
        newNums[0] = newNums[newNums.length - 1] = 1;

        return maxCoins2Mem(newNums, 0, newNums.length - 1, new int[newNums.length][newNums.length]);
    }

    private static int maxCoins2Mem(int[] nums, int left, int right, int[][] mems) {
        if (left + 1 >= right) {
            return 0;
        }

        if (mems[left][right] != 0) {
            return mems[left][right];
        }

        for (int i = left + 1; i < right; i++) {
            mems[left][right] = Math.max(mems[left][right], nums[left] * nums[i] * nums[right]
                    + maxCoins2Mem(nums, left, i, mems) + maxCoins2Mem(nums, i, right, mems));
        }

        return mems[left][right];
    }


    public static int maxCoinsDp(int[] nums) {
        int[] newNums = new int[nums.length + 2];
        System.arraycopy(nums, 0, newNums, 1, nums.length);
        newNums[0] = newNums[newNums.length - 1] = 1;

        int[][] dp = new int[newNums.length][newNums.length];
        for (int i = 2; i < newNums.length; i++) {
            for (int j = 0; j + i < newNums.length; j++) {
                for (int k = j + 1; k < j + i; k++){
                    dp[j][j + i] = Math.max(dp[j][j + i], newNums[j] * newNums[k] * newNums[j + i] + dp[j][k] + dp[k][j + i]);
                }
            }
        }

        return dp[0][newNums.length - 1];
    }
}
