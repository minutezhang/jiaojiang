package jiaojiang.leetcode.practice3.onlinejudge;

import utils.ListNode;

/**
 * @author: mizhang
 * @since: Nov 29, 2014 7:15:18 AM
 */
public class IntersectionOfTwoLinkedLists {
/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.


   For example, the following two linked lists:

    A:          a1 ? a2
                       ?
                         c1 ? c2 ? c3
                       ?
    B:     b1 ? b2 ? b3
    begin to intersect at node c1.


    Notes:

    If the two linked lists have no intersection at all, return null.
    The linked lists must retain their original structure after the function returns.
    You may assume there are no cycles anywhere in the entire linked structure.
    Your code should preferably run in O(n) time and use only O(1) memory.
    Credits:
    Special thanks to @stellari for adding this problem and creating all test cases.
 */

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = 0, l2 = 0;
        for(ListNode node = headA; node != null; node = node.next, l1++);
        for(ListNode node = headB; node != null; node = node.next, l2++);

        ListNode node1 = headA, node2 = headB;
        while (l1 < l2) {
            node2 = node2.next; //node2 is not null
            l2--;
        }

        while (l2 < l1) {
            node1 = node1.next;
            l1--;
        }

        while (node1 != null) {
            if (node1 == node2) {
                return node1;
            }
            node1 = node1.next;
            node2 = node2.next;
        }


        return null;
    }

    public static void main(String[] args) {
        ListNode root1 = ListNode.getSampleNode();
        ListNode root2 = ListNode.getIntersectedLinkedList(root1.next.next);

        ListNode.print(getIntersectionNode(root1, root2));
    }


    /*
    There are many solutions to this problem:

    Brute-force solution (O(mn) running time, O(1) memory):
    For each node ai in list A, traverse the entire list B and check if any node in list B coincides with ai.

    Hashset solution (O(n+m) running time, O(n) or O(m) memory):
    Traverse list A and store the address / reference to each node in a hash set. Then check every node bi in list B:
    if bi appears in the hash set, then bi is the intersection node.

    Two pointer solution (O(n+m) running time, O(1) memory):
    Maintain two pointers pA and pB initialized at the head of A and B, respectively. Then let them both traverse
    through the lists, one node at a time.
    When pA reaches the end of a list, then redirect it to the head of B (yes, B, that's right.); similarly when pB
    reaches the end of a list, redirect it the head of A.
    If at any point pA meets pB, then pA/pB is the intersection node.
    To see why the above trick would work, consider the following two lists: A = {1,3,5,7,9,11} and B = {2,4,9,11},
    which are intersected at node '9'. Since B.length (=4) < A.length (=6), pB would reach the end of the merged list
    first, because pB traverses exactly 2 nodes less than pA does. By redirecting pB to head A, and pA to head B, we
    now ask pB to travel exactly 2 more nodes than pA would. So in the second iteration, they are guaranteed to reach
    the intersection node at the same time.
    If two lists have intersection, then their last nodes must be the same one. So when pA/pB reaches the end of a
    list, record the last element of A/B respectively. If the two last elements are not the same one, then the two
    lists have no intersections.
     */

}
