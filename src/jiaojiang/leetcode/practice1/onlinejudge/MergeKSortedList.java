package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.ArrayList;

/**
 * @author: zhang
 * @since: Jun 3, 2013 11:18:45 PM
 */
public class MergeKSortedList {
    /*
    Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
     */
    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        while (lists.size() > 1) {
            for (int i = 0, n = lists.size(); i < (n >> 1); i++) {
                lists.set(i, mergeLists(lists.get(i), lists.get(n - i - 1)));
                lists.remove(n - i - 1);
            }
        }

        return lists.size() == 1 ? lists.get(0) : null;
    }

    public static ListNode mergeLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode head, node1 = list1, node2 = list2;

        if (node1.val > node2.val) {
            head = node2;
            node2 = node2.next;
        } else {
            head = node1;
            node1 = node1.next;
        }

        ListNode node = head;
        while (node1 != null && node2 != null) {
            if (node1.val > node2.val) {
                node.next = node2;
                node2 = node2.next;
            } else {
                node.next = node1;
                node1 = node1.next;
            }
            node = node.next;
        }

        if (node1 != null) {
            node.next = node1;
        } else {
            node.next = node2;
        }

        return head;
    }

    public static void test() {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);
        list1.next.next.next = new ListNode(7);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);
        list2.next.next.next = new ListNode(8);

        mergeLists(list1,  list2).print();
    }

    public static void main(String[] args){
        test();
    }

}
