package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.Map;
import java.util.HashMap;
import java.util.Random;

/**
 * @author: zhang
 * @since: Oct 26, 2013 9:59:27 PM
 */
public class RandomListNode {
    int label;
    RandomListNode next; 
    RandomListNode random;

    RandomListNode(int x) {
        this.label = x; 
    }

    public static RandomListNode constructRandomList(int length) {
        Map<Integer, RandomListNode> map = new HashMap<Integer, RandomListNode>();
        RandomListNode head = new RandomListNode(0);
        map.put(0, head);

        RandomListNode node = head;
        for (int i = 1; i < length; i++) {
            node.next = new RandomListNode(i);
            map.put(i, node.next);
            node = node.next;
        }

        node = head;
        Random r = new Random();
        while (node != null) {
            node.random = map.get(r.nextInt(length));
            node = node.next;
        }

        return head;
    }

    public void print() {
        RandomListNode node = this;
        while (node != null) {
            System.out.print("(" + node.label + ", " + node.random.label + ")\t");
            node = node.next;
        }
        System.out.println();
    }
}
