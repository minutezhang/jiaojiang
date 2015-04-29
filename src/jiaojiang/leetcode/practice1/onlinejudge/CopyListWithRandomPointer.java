package jiaojiang.leetcode.practice1.onlinejudge;

/**
 * @author: zhang
 * @since: Oct 26, 2013 9:57:50 PM
 */
public class CopyListWithRandomPointer {
    /*
    A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

    Return a deep copy of the list.
     */
    public static RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode node = head;

        while (node != null) {
            RandomListNode tmp = node.next;
            node.next = new RandomListNode(node.label);
            node.next.next = tmp;
            node = tmp;
        }

        node = head;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }

        node = head;
        RandomListNode dummyHead = new RandomListNode(0), newNode = dummyHead;
        
        while (node != null) {
            newNode.next = node.next;
            newNode = newNode.next;
            node.next = node.next.next;
            node = node.next;
        }

        return dummyHead.next;
    }

    public static void test() {
        RandomListNode node = RandomListNode.constructRandomList(5);
        node.print();

        copyRandomList(node).print();

        System.out.println("-----------");

        node = RandomListNode.constructRandomList(1);
        node.print();

        copyRandomList(node).print();
    }

    public static void  main(String[] args) {
        test();
    }

}
