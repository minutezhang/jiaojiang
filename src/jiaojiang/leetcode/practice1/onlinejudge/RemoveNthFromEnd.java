package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: Apr 14, 2013 4:09:30 PM
 */
public class RemoveNthFromEnd {
    /*
    Given a linked list, remove the nth node from the end of list and return its head.

    For example,

       Given linked list: 1->2->3->4->5, and n = 2.

       After removing the second node from the end, the linked list becomes 1->2->3->5.
    Note:
    Given n will always be valid.
    Try to do this in one pass.
     */

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }

        ListNode currentNode = head;
        int i = 0;
        while (i < n && currentNode.next != null) {
            currentNode = currentNode.next;
            i++;
        }

        if (i < n) {
            return head.next;
        }

        ListNode secondNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            secondNode = secondNode.next;
        }
        secondNode.next = secondNode.next.next;

        return head;
    }

//test cases:
//    {1}, 1	{}
//
//    {1,2}, 1	{1}
//
//    {1,2}, 2	{2}
//
//    {1,2,3}, 1	{1,2}
//
//    {1,2,3}, 2	{1,3}
//
//    {1,2,3}, 3	{2,3}
//
//    {1,2,3,4,5,6,7,8,9,10}, 7	{1,2,3,5,6,7,8,9,10}
//
//    {3,7,9,3,5,8,0}, 1	{3,7,9,3,5,8}
//
//    {4,5,4}, 1  {4, 5}
}
