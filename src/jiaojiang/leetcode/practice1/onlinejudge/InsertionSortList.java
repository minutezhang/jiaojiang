package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: mizhang
 * @since: Nov 13, 2013 10:40:11 AM
 */
public class InsertionSortList {
    /*
    Sort a linked list using insertion sort.
     */
    public static ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(0), node, nextNode, insertPos;

        for (node = head; node != null; node = nextNode) {
            for (insertPos = dummyHead; insertPos.next != null && node.val > insertPos.next.val; insertPos = insertPos.next);
            nextNode = node.next;
            node.next = insertPos.next;
            insertPos.next = node;
        }

        return dummyHead.next;
    }

    public static void test() {
        insertionSortList(ListNode.constructRandomList(10)).print();
        insertionSortList(ListNode.constructRandomList(10)).print();
    }

    public static void main(String[] args) {
        test();
    }
}
