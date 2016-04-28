package jiaojiang.leetcode.practice4.onlinejudge;

import java.util.List;
import java.util.ArrayList;

/**
 * @author zhang
 *
 * Created on Apr 22, 2016
 */
public class FindMedianFromDataStream {
    /*
    Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value.
    So the median is the mean of the two middle value.
    Examples:

    [2,3,4] , the median is 3

    [2,3], the median is (2 + 3) / 2 = 2.5

    Design a data structure that supports the following two operations:

        void addNum(int num) - Add a integer number from the data stream to the data structure.
        double findMedian() - Return the median of all elements so far.

    For example:

    add(1)
    add(2)
    findMedian() -> 1.5
    add(3)
    findMedian() -> 2
     */

    private class Heap {
        private List<Integer> storage;
        final private boolean isMinHeap;

        public Heap() {
            this(true);
        }

        public Heap(boolean isMinHeap) {
            storage = new ArrayList<Integer>();
            this.isMinHeap = isMinHeap;
        }

        public void add(int number) {
            storage.add(number);
            if (isMinHeap) {
                minHeapifyButtomUp(storage.size() - 1);
            } else {
                maxHeapifyButtomUp(storage.size() - 1);
            }
        }

        public void replaceTop(int number) {
            storage.set(0, number);
            if (isMinHeap) {
                minHeapify(0);
            } else {
                maxHeapify(0);
            }
        }

        public int getTop() {
            return size() == 0 ? Integer.MAX_VALUE : storage.get(0);
        }


        public int size() {
            return storage.size();
        }

        private void minHeapify(int i) {
            if (leftChild(i) >= size()) {
                return;
            }

            int index;
            if (rightChild(i) >= size()) {
                index = leftChild(i);
            } else {
                index = storage.get(leftChild(i)) < storage.get(rightChild(i)) ? leftChild(i) : rightChild(i);
            }

            if (storage.get(i) > storage.get(index)) {
                int min = storage.get(index);
                storage.set(index, storage.get(i));
                storage.set(i, min);
                minHeapify(index);
            }
        }

        private void maxHeapify(int i) {
            if (leftChild(i) >= size()) {
                return;
            }

            int index;
            if (rightChild(i) >= size()) {
                index = leftChild(i);
            } else {
                index = storage.get(leftChild(i)) > storage.get(rightChild(i)) ? leftChild(i) : rightChild(i);
            }

            if (storage.get(i) < storage.get(index)) {
                int max = storage.get(index);
                storage.set(index, storage.get(i));
                storage.set(i, max);
                maxHeapify(index);
            }
        }


        private void maxHeapifyButtomUp(int i) {
            if (i == 0) {
                return;
            }

            int p = parent(i);
            if (storage.get(p) < storage.get(i)) {
                int max = storage.get(i);
                storage.set(i, storage.get(p));
                storage.set(p, max);
                maxHeapifyButtomUp(p);
            }
        }

        private void minHeapifyButtomUp(int i) {
            if (i == 0) {
                return;
            }

            int p = parent(i);

            if (storage.get(p) > storage.get(i)) {
                int max = storage.get(i);
                storage.set(i, storage.get(p));
                storage.set(p, max);
                minHeapifyButtomUp(p);
            }
        }

        private int leftChild(int i) {
            return (i << 1) + 1;
        }

        private int rightChild(int i) {
            return (i + 1) << 1;
        }

        private int parent(int i) {
            return i == 0 ? 0 : (i - 1) >> 1;
        }

    }


    private Heap minHeap = new Heap();
    private Heap maxHeap = new Heap(false);

    public void addNum(int num) {
        int min = minHeap.getTop(), max = maxHeap.getTop();
//        if (num <= max) {
//            if (maxHeap.size() == minHeap.size()) {
//                maxHeap.add(num);
//            } else {
//                maxHeap.replaceTop(num);
//                minHeap.add(max);
//            }
//        } else if (num <= min){
//            if (maxHeap.size() == minHeap.size()) {
//                maxHeap.add(num);
//            } else {
//                maxHeap.add(num);
//            }
//
//        } else {
//            if (maxHeap.size() == minHeap.size()) {
//                minHeap.replaceTop(num);
//                maxHeap.add(min);
//            } else {
//                minHeap.add(num);
//            }
//        }
        if (maxHeap.size() == minHeap.size()) {
            if (num <= min) {
                maxHeap.add(num);
            } else {
                minHeap.replaceTop(num);
                maxHeap.add(min);
            }
        } else {
            if (num <= max) {
                maxHeap.replaceTop(num);
                minHeap.add(max);
            } else {
                minHeap.add(num);
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.getTop() + maxHeap.getTop() ) / 2.0;
        }
        
        return maxHeap.getTop();
    }
}
