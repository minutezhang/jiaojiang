package jiaojiang.leetcode.practice3.onlinejudge;

/**
 * @author: mizhang
 * @since: Dec 8, 2014 4:21:08 PM
 */
public class CopyListWithRandomPointer {
    /*
    A linked list is given such that each node contains an additional random pointer which could point to any node in
    the list or null.

    Return a deep copy of the list.
     */
    public static RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode newNode, node;

        for (node = head; node != null; newNode = new RandomListNode(node.label), newNode.next = node.next, node.next = newNode, node = newNode.next);

        for (node = head; node != null; node.next.random = node.random == null ? null : node.random.next, node = node.next.next);

        RandomListNode newHead = new RandomListNode(0);

        for (node = head, newNode = newHead; node != null; newNode.next = node.next, newNode = newNode.next, node.next = newNode.next, node = node.next);
        
        return newHead.next;
    }

    public static void test() {
        RandomListNode rln = RandomListNode.getSampleRandomList(5);
        rln.print();

        copyRandomList(rln).print();
        if (copyRandomList(null) == null) {
            System.out.println("Passed");
        };

    }

    public static void main(String[] args) {
        test();
    }
}
