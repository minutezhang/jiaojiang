package jiaojiang.leetcode.practice5.onlinejudge;

import java.util.Arrays;

public class Heaters {
    /**
     * Winter is coming! During the contest, your first job is to design a standard heater with a fixed warm radius to
     * warm all the houses.
     * <p>
     * Every house can be warmed, as long as the house is within the heater's warm radius range.
     * <p>
     * Given the positions of houses and heaters on a horizontal line, return the minimum radius standard of heaters
     * so that those heaters could cover all houses.
     * <p>
     * Notice that all the heaters follow your radius standard, and the warm radius will the same.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: houses = [1,2,3], heaters = [2]
     * Output: 1
     * Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the
     * houses can be warmed.
     * <p>
     * Example 2:
     * <p>
     * Input: houses = [1,2,3,4], heaters = [1,4]
     * Output: 1
     * Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all
     * the houses can be warmed.
     * <p>
     * Example 3:
     * <p>
     * Input: houses = [1,5], heaters = [2]
     * Output: 3
     * <p>
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= houses.length, heaters.length <= 3 * 10^4
     * 1 <= houses[i], heaters[i] <= 10^9
     */
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int j = 0, r = 0;
        for (int i = 0; i < houses.length; ++i) {
            while (j < heaters.length - 1 && Math.abs(houses[i] - heaters[j + 1]) <= Math.abs(houses[i] - heaters[j])) {
                ++j;
            }
            r = Math.max(r, Math.abs(houses[i] - heaters[j]));

        }
        return r;
    }

    public static int findRadius2(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int i = 0, j = 0, r = 0;
        if (heaters.length == 1) {
            if (houses.length == 1) {
                return Math.abs(houses[0] - heaters[0]);
            }
            return Math.max(Math.abs(houses[0] - heaters[0]), Math.abs(houses[houses.length - 1] - heaters[0]));
        }

        while (i < houses.length && j + 1 < heaters.length) {
            if (houses[i] >= heaters[j] && houses[i] < heaters[j + 1]) {
                r = Math.max(r, Math.min(houses[i] - heaters[j], heaters[j + 1] - houses[i]));
                ++i;
            } else if (houses[i] < heaters[j]) {
                r = Math.max(r, heaters[j] - houses[i]);
                ++i;
            } else {
                ++j;
            }
        }

        return i == houses.length ? r : Math.max(r, houses[houses.length - 1] - heaters[j]);
    }
}