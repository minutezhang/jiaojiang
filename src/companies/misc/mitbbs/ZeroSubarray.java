package companies.misc.mitbbs;

import utils.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: mizhang
 * @since: Sep 18, 2013 2:22:07 PM
 */
public class ZeroSubarray {
    /*
    Given an integer array, find the subarray that sums to 0
    The first returned value is the start index (inclusive) and the second is the end index (exclusive) of the subarray
     */
    public static int[] findSumToZero(int[] data) {
        if (data.length == 0) {
            return new int[]{-1, -1};
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] sum = new int[data.length];
        sum[0] = data[0];

        int rightSum = data[data.length - 1];
        map.put(rightSum, data.length - 1);

        for (int i = 1; i < data.length; i++) {
            sum[i] = sum[i - 1] + data[i];
            if (sum[i] == 0) {
                return new int[] {0, i + 1};
            }
            rightSum += data[data.length - i - 1];
            //if the right sum already exist, do not overide it, keep the max index
            if (!map.containsKey(rightSum)) {
                map.put(rightSum, data.length - i - 1);
            }
        }

        if (sum[data.length - 1] == 0) {
            return new int[]{0, data.length};
        }

        if (map.containsKey(0)) {
            return new int[] {map.get(0), data.length};
        }

        for (int i = 0; i < data.length - 1; i++) {
            if (map.containsKey(sum[data.length - 1] - sum[i]) && map.get(sum[data.length - 1] - sum[i]) > i + 1) {
                return new int[]{i + 1, map.get(sum[data.length - 1] - sum[i])};
            }
        }

        return new int[]{-1, -1};
    }

    public static void test() {
        Utils.printTestArrayln(findSumToZero(new int[]{1, 2, 3, 4, 5, 6, 7, 8}), new int[]{-1, -1});
        Utils.printTestArrayln(findSumToZero(new int[]{1, 2, 3, 4, 5, -7, -8, 6}), new int[]{0, 7});
        Utils.printTestArrayln(findSumToZero(new int[]{-1, 6, -3, 4, -5, 2, -1, 6}), new int[]{3, 7});
        Utils.printTestArrayln(findSumToZero(new int[]{-1, 6, -3, 0, -5, 2, -1, 6}), new int[]{1, 6});      // or (3, 4)
    }

    public static void main(String[] args) {
        test(); 
    }
}
