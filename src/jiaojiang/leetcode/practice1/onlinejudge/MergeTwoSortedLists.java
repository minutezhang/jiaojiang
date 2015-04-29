package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: mizhang@akamai.com
 */
public class MergeTwoSortedLists {
    /*
    Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together
    the nodes of the first two lists.
     */

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode node1 = l1, node2 = l2, current, head;

        if (node1.val <= node2.val) {
            head = node1;
            current = node1;
            node1 = node1.next;
        } else {
            head = node2;
            current = node2;
            node2 = node2.next;
        }

        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                current.next = node1;
                current = node1;
                node1 = node1.next;
            } else {
                current.next = node2;
                current = node2;
                node2 = node2.next;
            }
        }

        if (node1 == null) {
            current.next = node2;
        } else {
            current.next = node1;
        }

        return head;
    }


    //test cases:
//{}, {}	{}
//
//{}, {0}	{0}
//
//{1}, {}	{1}
//
//{2}, {1}	{1,2}
//
//{1}, {2}	{1,2}
//
//{1}, {1}	{1,1}
//
//{}, {1,2,4}	{1,2,4}
//
//{1,3,4}, {0}	{0,1,3,4}
//
//{5}, {1,2,4}	{1,2,4,5}
}
