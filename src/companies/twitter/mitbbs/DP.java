package companies.twitter.mitbbs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: zhang
 * @since: Feb 12, 2013 10:20:53 PM
 */
public class DP {

    public static int getShortestPathNDPHelper(int[][] checkboard, int i, int j) {

        if (j >= checkboard[0].length || j < 0) {
            return Integer.MAX_VALUE;
        }

        if (i == 0) {
            return checkboard[i][j];
        }

        return Math.min(getShortestPathNDPHelper(checkboard, i - 1, j - 1), Math.min(getShortestPathNDPHelper(checkboard, i - 1, j), getShortestPathNDPHelper(checkboard, i - 1, j + 1))) + checkboard[i][j];
    }

    public static int getShortestPathNDP(int[][] checkboard) {
        int p = Integer.MAX_VALUE;
        for (int i = 0; i < checkboard[0].length; i++) {
            int c = getShortestPathNDPHelper(checkboard, checkboard.length - 1, i);
            if( p > c) {
                p = c;
            }
        }
        return p;
    }

    public static int getShortestPath(int[][] checkboard) {
        int[][] costs = new int[checkboard.length][checkboard[0].length + 2];
        for (int i = 0; i < costs[0].length - 2; i++) {
            costs[0][i + 1] = checkboard[0][i];
        }
        costs[0][0] = Integer.MAX_VALUE;
        costs[0][costs[0].length - 1] = Integer.MAX_VALUE;


        for (int i = 1; i < costs.length; i++) {
            for (int j = 0; j < costs[i].length - 2; j++) {
                costs[i][j + 1] = Math.min(Math.min(costs[i - 1][j], costs[i - 1][j + 1]), costs[i - 1][j + 2]) + checkboard[i][j];
            }
            costs[i][0] = Integer.MAX_VALUE;
            costs[i][costs[i].length - 1] = Integer.MAX_VALUE;
        }

        int p = Integer.MAX_VALUE;
        for (int i = 1; i < costs[costs.length - 1].length - 1; i++) {
            if (p > costs[costs.length - 1][i]) {
                p = costs[costs.length - 1][i];
            }
        }

        return p;
    }

    public static List<Integer> minimalCoins(int[] coins, int target) {

        List<Integer> ret = new ArrayList<Integer>();

        if (target < 0) {
            return null;
        }

        int minCoins = Integer.MAX_VALUE;
        int coin = -1;

        for (int c : coins) {
            if (target == c) {
                ret.add(c);
                return ret;
            }
        }

        List<Integer> tmp, min = null;
        for (int c: coins) {
            tmp = minimalCoins(coins, target - c);
            if (tmp != null &&tmp.size() < minCoins) {
                minCoins = tmp.size();
                min = tmp;
                coin  = c;
            }
        }

        ret.addAll(min);
        ret.add(coin);
        return ret;
    }

    public static int minC(int[] coins, int target) {

        Set<Integer> integers = new HashSet<Integer>();

        integers.add(0);

        int count = 0;

        while (count < Integer.MAX_VALUE) {
            Integer[] nCoins = integers.toArray(new Integer[0]);
            integers.clear();
            for (int i : nCoins) {
                for (int c : coins) {
                    if (i + c == target) {
                        return count + 1;
                    }
                    integers.add(i + c);
                }
            }
            count++;
        }

        return count;
    }


    public static void testCoins() {

        int[] coins = new int[]{1, 2, 5, 10};
        int target = 28;
        for (int i : minimalCoins(coins, target)) {
            System.out.println(i);
        }

        System.out.println("\n" + minC(coins,target));
    }

    public static void main(String[] args) {

        int[][] checkboard = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 1, 9}};

        System.out.println(getShortestPathNDP(checkboard));
        System.out.println(getShortestPath(checkboard));

    }
}
