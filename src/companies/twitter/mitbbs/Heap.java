package companies.twitter.mitbbs;

import java.util.*;

/**
 * @author: zhang
 * @since: Jan 16, 2013 10:01:23 PM
 */
public class Heap {

    protected int[] heap;
    protected int size;

    public Heap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    public Heap(int[] heap) {
        this.heap = heap;
        this.size = heap.length;
    }

    public static Heap findKMin(Iterator<Integer> iter, int k) {
        Heap maxHeap = new Heap(k);
        while (iter.hasNext() && maxHeap.size < maxHeap.heap.length) {
            maxHeap.heap[maxHeap.size++] = iter.next();
        }

        maxHeap.heapify();

        while (iter.hasNext()) {
            int i = iter.next();
            if (i < maxHeap.heap[0]) {
                maxHeap.heap[0] = i;
                maxHeap.heapify(0);
            }
        }

        return maxHeap;
    }

    protected static int leftChild(int i) {
        return 2 * i  + 1;
    }

    protected static int rightChild(int i) {
        return 2 * (i + 1);
    }

    protected static int parent(int i) {
        return (i - 1) >>> 1;
    }

    protected int max(int i, int j) {
        if (i >= size && j >= size) {
            return Integer.MAX_VALUE;
        }

        if (i >= size) {
            return j;
        }

        if (j >= size) {
            return i;
        }
        
        return heap[i] < heap[j] ? j : i;
    }

    protected void swap(int i, int j) {
        if (i != j) {
            heap[i] ^= heap[j];
            heap[j] ^= heap[i];
            heap[i] ^= heap[j];
        }
    }

    private void heapify(int i) {
        if (size == 0) {
            return;
        }
        
        int maxIdx = max(i, max(leftChild(i), rightChild(i)));
        if (i != maxIdx) {
            swap(i, maxIdx);
            heapify(maxIdx);
        }
    }

    public void heapify() {
        for (int i = size >>> 1; i >= 0; i--) {
            heapify(i);
        }
    }

    public void sort() {
        heapify();
        for (int i = size - 1; i > 0; i--) {
            swap(0, i);
            size--;
            heapify(0);
        }

        size = heap.length;
    }

    public String toString() {
        StringBuffer out = new StringBuffer();
        for (int i = 0; i < size - 1; i++) {
            out.append(heap[i]).append('\t');
        }
        out.append(heap[size - 1]);
        return out.toString();
    }

    public static void main(String[] args) {
        int[] ints = new int[]{10, 5, 16, 3, 6, 13, 19, 1, 8, 31};
        Heap heap = new Heap(ints);
        heap.sort();
        System.out.println(heap);

        List<Integer> list = new ArrayList<Integer>();
        for (int i : ints) {
            list.add(i);
        }
        System.out.println(findKMin(list.iterator(), 5));
    }
}
