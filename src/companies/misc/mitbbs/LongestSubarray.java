package companies.misc.mitbbs;

import utils.Utils;

/**
 * @author: zhang
 * @since: Oct 5, 2013 10:30:08 PM
 */
/*
An int array with length N, which contains M distinct numbers, where N >> M

For example, 0011111222222333333333333

Find the longest subarray with repeating numbers, i.e., 333333333333
 */
public class LongestSubarray {

    public static int[] longestRepeatingSubarray(int[] sortedData) {
        int start = 0, maxLength = 0, maxStart = 0;

        while (start < sortedData.length) {
            int end = binarySearch(sortedData, start);
            if (end - start > maxLength) {
                maxLength = end - start;
                maxStart = start;
            }
            start = end;
        }

        return new int[]{maxStart, maxLength};
    }

    /*
    return the index of the first next integer after sortedData[index]
     */
    private static int binarySearch(int[] sortedData, int index) {
        int start = index, end = sortedData.length - 1, mid;
        while (start <= end) {
            mid = (start + end) >>> 1;
            if (sortedData[mid] > sortedData[index] && mid - 1 >= 0 && sortedData[mid - 1] == sortedData[index]) {
                return mid;
            }

            if (sortedData[mid] == sortedData[index]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return sortedData.length;
    }

    private static void testBS(){
        System.out.println(binarySearch(new int[]{0, 0, 0, 1, 1, 1, 4, 5, 6, 7, 7, 7, 7, 7}, 9)); // 14
        System.out.println(binarySearch(new int[]{0, 0, 0, 1, 1, 1, 4, 5, 6, 7, 7, 7, 7, 7}, 3)); // 6
    }

    public static void test() {
        Utils.printTestArrayln(longestRepeatingSubarray(new int[]{0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}), new int[]{13, 12});
        Utils.printTestArrayln(longestRepeatingSubarray(new int[]{0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3}), new int[]{7, 6});
        Utils.printTestArrayln(longestRepeatingSubarray(new int[]{0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 3, 3, 3, 3}), new int[]{0, 7});
    }

    public static void main(String[] args) {
//        testBS();
        test();
    }
}