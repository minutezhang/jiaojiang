package jiaojiang.leetcode.facebook.onlinejudge;

import utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhang
 *
 * Created on Sep 6, 2016
 */
public class MergeKSortedLists {
    /*
    Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyNode = new ListNode(0), node;
        int size = preprocess(lists);
        heapify(lists, size);

        for (node = dummyNode; size > 0; node = node.next) {
            node.next = lists[0];
            lists[0] = lists[0].next;
            if (lists[0] == null) {
                size--;
                swap(lists, 0, size);
            }
            heapify(lists, size);
        }

        node.next = null;

        return dummyNode.next;
    }

    private static int preprocess(ListNode[] lists) {
        int size = lists.length;
        for (int i = 0; i < size;) {
            if (lists[i] == null) {
                swap(lists, i, --size);
            } else {
                i++;
            }
        }
        return size;
    }

    private static void swap(ListNode[] lists, int i, int j) {
            ListNode tmpNode = lists[i];
            lists[i] = lists[j];
            lists[j] = tmpNode;
    }

    private static void heapify(ListNode[] lists, int size) {
        for (int i = size; i >= 0; i--) {
            heapify(lists, i, size);
        }
    }

    private static void heapify(ListNode[] lists, int i, int size) {
        int leftChildIndex = 2 * i + 1, rightChildIndex = 2 * i + 2;
        if (leftChildIndex >= size) {
            return;
        }

        int minIndex = rightChildIndex >= size || lists[leftChildIndex].val <= lists[rightChildIndex].val?
                leftChildIndex : rightChildIndex;

        if (lists[i].val > lists[minIndex].val) {
            swap(lists, i, minIndex);
        }

        heapify(lists, minIndex, size);
    }
}
