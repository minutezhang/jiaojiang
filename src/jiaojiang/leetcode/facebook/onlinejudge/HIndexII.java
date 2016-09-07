package jiaojiang.leetcode.facebook.onlinejudge;

/**
 * @author zhang
 *
 * Created on Sep 5, 2016
 */
public class HIndexII {
    /*
    Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

    Hint:
        Expected runtime complexity is in O(log n) and the input is sorted.
     */
    public static int hIndex(int[] citations) {
        int start = 0, end = citations.length - 1, hIndex = citations.length + 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (citations[mid] >= citations.length - mid) {
                end = mid - 1;
                hIndex = citations.length - mid;
            } else {
                start = mid + 1;
            }
        }

        return hIndex > citations.length ? 0 : hIndex;
    }
}
