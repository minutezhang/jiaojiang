package jiaojiang.leetcode.practice3.onlinejudge;

import java.util.Map;
import java.util.HashMap;
import java.util.Random;

/**
 * @author: mizhang
 * @since: Dec 8, 2014 4:21:46 PM
 */
public class RandomListNode {
    int label;
    RandomListNode next, random;
    
    RandomListNode(int x) {
        this.label = x;
    }

    public static RandomListNode getSampleRandomList(int length) {
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

