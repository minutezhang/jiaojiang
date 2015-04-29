package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.Random;

/**
 * @author: zhang
 * @since: Apr 14, 2013 4:10:28 PM
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
   }

    public void print() {
            ListNode next = this;
            while (next.next != null) {
                System.out.print(next.val + " --> ");
                next = next.next;
            }
            System.out.println(next.val);
    }

    public static ListNode constructList(int n) {
        ListNode head = new ListNode(0);
        ListNode node = head;

        for (int i = 1; i < n; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }

        return head;
    }

    public static ListNode constructRandomList(int n) {
        Random r = new Random();
        ListNode head = new ListNode(r.nextInt( n << 3));
        ListNode node = head;

        for (int i = 1; i < n; i++) {
            node.next = new ListNode(r.nextInt( n << 3 ));
            node = node.next;
        }

        return head;
    }
}
