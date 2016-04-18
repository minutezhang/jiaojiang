package jiaojiang.leetcode.practice4.onlinejudge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhang
 *
 * Created on Mar 29, 2016
 */
public class CountOfSmallerNumberAferSelf {
    /*
     You are given an integer array nums and you have to return a new counts array. The counts array has the property
     where counts[i] is the number of smaller elements to the right of nums[i].

    Example:

    Given nums = [5, 2, 6, 1]

    To the right of 5 there are 2 smaller elements (2 and 1).
    To the right of 2 there is only 1 smaller element (1).
    To the right of 6 there is 1 smaller element (1).
    To the right of 1 there is 0 smaller element.

    Return the array [2, 1, 1, 0].
     */
    public static List<Integer> countSmaller(int[] nums) {
        Integer[] counts = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            counts[i] = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    counts[i]++;
                }
            }
        }

        return Arrays.asList(counts);
    }

    public static List<Integer> countSmallerBinarySearch(int[] nums) {
        Integer[] counts = new Integer[nums.length];
        List<Integer> tmp = new ArrayList<Integer>(nums.length);
        for (int i = nums.length - 1; i >= 0; i--) {
            int insertingPosition = insertingPosition(tmp, nums[i]);
            counts[i] = insertingPosition;
            tmp.add(insertingPosition, nums[i]);
        }

        return Arrays.asList(counts);
    }

    private static int insertingPosition(List<Integer> nums, int target) {
        int start = 0, end = nums.size() - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (target == nums.get(mid) && (mid == 0 || nums.get(mid - 1) < target)) {
                return mid;
            }
            if (target <= nums.get(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }


    public static List<Integer> countSmallerBinaryIndexedTree(int[] nums) {
        //convert to indice so that the max value is bounded. If it is the permutation of 1, 2, ..., n, then no need to
        //convert to indice
        int[] sorted = nums.clone();
        int[] indices = new int[nums.length];
        int[] binaryIndexedTree = new int[nums.length + 1];
        Integer[] counts = new Integer[nums.length];

        Arrays.sort(sorted);
        for (int i = 0; i < indices.length; i++) {
            indices[i] = Arrays.binarySearch(sorted, nums[i]);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
//            counts[i] = 0;
//            for (int j = indices[i]; j > 0; counts[i] += binaryIndexedTree[j], j -= j & -j);
//            for (int j = int[i] + 1; j < binaryIndexedTree.length; binaryIndexedTree[j]++, j += j & -j);
            counts[i] = new Integer(get(binaryIndexedTree, indices[i] - 1));
            update(binaryIndexedTree, indices[i]);
        }

        return Arrays.asList(counts);
    }

    private static void update(int[] binaryIndexedTree, int index) {
        for (int i = index + 1; i < binaryIndexedTree.length; binaryIndexedTree[i]++, i += i & -i);
    }

    private static int get(int[] binaryIndexedTree, int index) {
        int ret = 0;
        for (int i = index + 1; i > 0; ret += binaryIndexedTree[i], i -= i & -i);
        return ret;
    }
}
