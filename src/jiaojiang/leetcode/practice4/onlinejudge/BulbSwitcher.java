package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Feb 25, 2016
 */
public class BulbSwitcher {
    /*
     There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb.
     On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the ith
     round, you toggle every i bulb. For the nth round, you only toggle the last bulb. Find how many bulbs are on after
     n rounds.

    Example:

    Given n = 3.

    At first, the three bulbs are [off, off, off].
    After first round, the three bulbs are [on, on, on].
    After second round, the three bulbs are [on, off, on].
    After third round, the three bulbs are [on, off, off].

    So you should return 1, because there is only one bulb is on.
     */
    public static int bulbSwitch(int n) {
        boolean[] flags = new boolean[n];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; i * j <= n; j++) {
                flags[i * j - 1] = !flags[i * j - 1];
            }
        }

        int count = 0;
        for (boolean flag : flags) {
            if (flag) {
                count++;
            }
        }
        
        return count;
    }

    public static int bulbSwitch2(int n) {
        int i = 0;
        for (int j = 1; j * j <= n; j++, i++);
        return i;
    }
}
