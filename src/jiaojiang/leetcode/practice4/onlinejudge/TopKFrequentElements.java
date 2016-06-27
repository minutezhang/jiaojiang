package jiaojiang.leetcode.practice4.onlinejudge;

import utils.Utils;

import java.util.*;

/**
 * @author zhang
 *
 * Created on May 2, 2016
 */
public class TopKFrequentElements {
    /*
    Given a non-empty array of integers, return the k most frequent elements.

    For example,
    Given [1,1,1,2,2,3] and k = 2, return [1,2].

    Note:

        You may assume k is always valid, 1 ² k ² number of unique elements.
        Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
     */
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();

        for (int i : nums) {
            int count = counts.containsKey(i) ? counts.get(i) : 0;
            counts.put(i, count + 1);
        }

        Integer[] topK = new Integer[k];
        int size = 0;

        for (int i : counts.keySet()) {
            if (size < k) {
                topK[size++] = i;
            }

            if (size == k) {
                for (int j = k - 1; j >= 0; j--) {
                    heapify(topK, j, k, counts);
                }
                size++;
            }

            if (size > k && counts.get(topK[0]) < counts.get(i)) {
                topK[0] = i;
                heapify(topK, 0, k, counts);
            }
        }

        // heap sort
        for (int i = k; i > 0; i--) {
            swap(topK, 0, i - 1);
            heapify(topK, 0, i - 1, counts);
        }

        return Arrays.asList(topK);
    }

    private static void heapify(Integer[] heap, int index, int size, Map<Integer, Integer> counts) {
        int leftChild = (index  << 1)  + 1, rightChild = (index + 1) << 1;
        if (leftChild >= size) {
            return;
        }
        int minIndex = rightChild >= size || counts.get(heap[leftChild]) < counts.get(heap[rightChild]) ? leftChild : rightChild;
        if (counts.get(heap[index]) > counts.get(heap[minIndex])) {
            swap(heap, minIndex, index);
            heapify(heap, minIndex, size, counts);
        }
    }

    private static void swap(Integer[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
