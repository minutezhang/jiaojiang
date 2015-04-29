package companies.amazon.mitbbs;

/**
 * @author: zhang
 * @since: Aug 29, 2010 11:55:10 PM
 */
public class Lists {

    public static int findMaxConsecutiveSum(int[] list) {
        int maxSum = Integer.MIN_VALUE, sum = 0;
        for (int i : list) {
            if (i > maxSum) {
                maxSum = i;
            }
        }
        if (maxSum <= 0) {
            return maxSum;
        }

        for (int i = 0; i < list.length; i++) {
            if (list[i] < 0 && sum > maxSum) {
                maxSum = sum;
            }
            sum = Math.max(0, sum + list[i]);
        }

        return maxSum;

    }
}
