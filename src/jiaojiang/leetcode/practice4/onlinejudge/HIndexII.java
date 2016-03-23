package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Mar 20, 2016
 */
public class HIndexII {
    /*
    Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

    Hint:

        Expected runtime complexity is in O(log n) and the input is sorted.
     */
    public static int hIndex(int[] citations) {
        int start = 0, end = citations.length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (citations[citations.length - mid - 1] == mid + 1) {
                return mid + 1;
            }

            if (citations[citations.length - mid - 1] < mid + 1) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return start;
    }
}
