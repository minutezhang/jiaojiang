package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: May 6, 2013 8:11:58 PM
 */
public class SearchInsertPosition {
    /*
    Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

    You may assume no duplicates in the array.

    Here are few examples.
    [1,3,5,6], 5 ? 2
    [1,3,5,6], 2 ? 1
    [1,3,5,6], 7 ? 4
    [1,3,5,6], 0 ? 0
     */
    public static int searchInsert(int[] A, int target) {
        int start = 0, end = A.length - 1;

        while (start <= end) {
            int mid = (start + end) >>> 1;

            if (A[mid] == target) {
                return mid;
            }

            if (A[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }

    public static void test() {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5)); //2
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2)); //1
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7)); //4
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 0)); //0
    }

    public static void main(String[] args) {
        test();
    }
}
