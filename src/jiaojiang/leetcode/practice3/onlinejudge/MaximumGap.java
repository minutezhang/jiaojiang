package jiaojiang.leetcode.practice3.onlinejudge;

import java.util.Arrays;

/**
 * @author: mizhang
 * @time: 2/3/15 9:18 PM
 */
public class MaximumGap {
    /*
    Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

    Try to solve it in linear time/space.

    Return 0 if the array contains less than 2 elements.

    You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.

    Credits:
    Special thanks to @porker2008 for adding this problem and creating all test cases.
     */
    public static int maximumGap(int[] num) {
        Arrays.sort(num);
        int maxGap = 0;
        for (int i = 0; i < num.length - 1; i++) {
            maxGap = Math.max(num[i + 1] - num[i], maxGap);
        }

        return maxGap;
    }


    public static int maximumGap2(int[] num) {

        if (num.length <= 1) {
            return 0;
        }

        int min = Integer.MAX_VALUE, max = 0;
        for (int i : num) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        int bucketSize = Math.max(1, (max - min + 1) / num.length);
//        int numBuckets = (int) Math.ceil((max - min + 1.0) / bucketSize);
        int numBuckets = (max - min + bucketSize) / bucketSize;
        int[] bucketMin = new int[numBuckets];
        int[] bucketMax = new int[numBuckets];

        for (int i = 0; i < numBuckets; i++) {
            bucketMin[i] = max;
            bucketMax[i] = min - 1;
        }

        for (int i : num) {
            int bucketIndex = (i - min) / bucketSize;
            bucketMin[bucketIndex] = Math.min(bucketMin[bucketIndex], i);
            bucketMax[bucketIndex] = Math.max(bucketMax[bucketIndex], i);
        }

        int index;
        for (index = 0; index < numBuckets && bucketMax[index] == min - 1; index++);
        int maxGap = 0;
//        int maxGap = bucketSize;
        for (int start = bucketMax[index++]; index < numBuckets; index++) {
            if (bucketMax[index] != min - 1) {
                maxGap = Math.max(maxGap, bucketMin[index] - start);
                start = bucketMax[index];
            }
        }

        return maxGap;
    }
}
