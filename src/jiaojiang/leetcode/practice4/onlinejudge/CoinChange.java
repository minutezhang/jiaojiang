package jiaojiang.leetcode.practice4.onlinejudge;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

/**
 * @author zhang
 *
 * Created on Feb 25, 2016
 */
public class CoinChange {
    /**
     *  You are given coins of different denominations and a total amount of money amount. Write a function to
     * compute the fewest number of coins that you need to make up that amount. If that amount of money
     * cannot be made up by any combination of the coins, return -1.

        Example 1:
        coins = [1, 2, 5], amount = 11
        return 3 (11 = 5 + 5 + 1)

        Example 2:
        coins = [2], amount = 3
        return -1.

        Note:
        You may assume that you have an infinite number of each kind of coin.
     */
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);

        return coinChangeRecursive(coins, 0, amount);
    }

    private static int coinChangeRecursive(int[] coins, int index, int amount) {
        if (amount == 0) {
            return 0;
        }

        if (index >= coins.length || coins[index] > amount) {
            return -1;
        }

        int numCoins = coinChangeRecursive(coins, index, amount - coins[index]);
        int numCoins2 = coinChangeRecursive(coins, index + 1, amount);

        if (numCoins == -1 && numCoins2 == -1) {
            return -1;
        }

        if (numCoins == -1 || numCoins2 == -1) {
            return Math.max(1 + numCoins, numCoins2);
        }

        return Math.min(1 + numCoins, numCoins2);
    }


    public static int coinChangeDp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        
        Set<Integer>[] remains = new HashSet[2];
        remains[0] = new HashSet<Integer>();
        remains[1] = new HashSet<Integer>();

        remains[0].add(amount);

        int i = 0;
        while (!remains[i & 1].isEmpty()) {
            for (int remain : remains[i & 1]) {
                for (int denom : coins) {
                    if (remain - denom == 0) {
                        return i + 1;
                    }

                    if (remain - denom > 0) {
                        remains[(i + 1) & 1].add(remain - denom);
                    }
                }
            }
            remains[i & 1].clear();
            i++;
        }
        
        return -1;
    }
}
