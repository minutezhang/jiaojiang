package jiaojiang.leetcode.practice3.onlinejudge;

import utils.ListNode;

import java.util.List;

/**
 * @author: zhang
 * @date: Mar 19, 2015 4:29:50 PM
 */
public class MergeKSortedLists {
    /*
    Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
    */
    public static ListNode mergeKLists(List<ListNode> lists) {
        ListNode dummyHead = new ListNode(0), node = dummyHead;
        ListNode[] heap = new ListNode[lists.size()];
        int size = 0;
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                heap[size++] = lists.get(i);
            }
        }

        heapify(heap, size);

        while (size > 0) {
            node.next = heap[0];
            node = node.next;
            if (node.next == null) {
                heap[0] = heap[--size];
            } else {
                heap[0] = node.next;
            }

            heapify(heap, size, 0);
        }

        return dummyHead.next;
    }

    //min-Heap
    private static void heapify(ListNode[] heap, int size) {
        for (int i = size >> 1; i >= 0; i--) {
            heapify(heap, size, i);
        }
    }

    //min-heap
    private static void heapify(ListNode[] heap, int size, int index) {
        if ((index << 1) >= size - 1) {
            return;
        }

        int minIndex = ((index + 1) << 1) >= size || heap[(index << 1) + 1].val < heap[(index + 1) << 1].val? (index << 1) + 1 : (index + 1) << 1;
        if (heap[index].val > heap[minIndex].val) {
            ListNode tmp = heap[index];
            heap[index] = heap[minIndex];
            heap[minIndex] = tmp;
            heapify(heap, size, minIndex);
        }
    }


    public static ListNode mergeKLists2(List<ListNode> lists) {
        while (lists.size() > 1) {
            for (int i = 0, s = lists.size(); i < s >> 1; i++) {
                lists.set(i, mergeLists(lists.get(i), lists.get(s - i - 1)));
                lists.remove(s - i - 1);
            }
        }

        return lists.size() == 1 ? lists.get(0) : null;
    }

    private static ListNode mergeLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(0), node = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }

        node.next = list1 != null ? list1 : list2;

        return dummyHead.next;
    }
}
