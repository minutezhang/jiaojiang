package companies.google.mitbbs;

import java.util.Set;
import java.util.HashSet;

/**
 * @author: mizhang
 * @since: Nov 22, 2013 4:45:17 PM
 */
public class Sum2Zero {
    /*
    Given a integer array, test if there is any consequel subarray which sum
    of elements is 0.
            [7, 1, 1, -2, 3, 4] ==> true [1, 1, -2]
     */
    public static boolean sum2Zero(int[] data) {
        Set<Long> sumSet = new HashSet<Long>();
        long sum = 0;

        for (int i = 0; i < data.length; i++) {
            sum += data[i];
            if (sumSet.contains(sum)) {
                return true;
            }
            sumSet.add(sum);
        }

        return false;
    }

    private static void test() {
        utils.Utils.printTestln(sum2Zero(new int[]{7, 1, 1, -2, 3, 4}), true);
    }

    public static void main(String[] args) {
        test();
    }
    
}
