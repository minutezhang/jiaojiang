package companies.linkedin.glassdoor;

/**
 * @augthor: zhang
 * @since: Aug 29, 2010 2:28:04 PM
 */
public class LinkedList {
    public LinkedNode head;

    public static class LinkedNode {
        public int value;
        public LinkedNode next;
    }

    public LinkedList(int n) {
        head = new LinkedNode();
        head.value = 0;
        head.next = null;

        LinkedNode preNode = head;
        for(int i = 1; i < n; i++) {
            LinkedNode node = new LinkedNode();
            node.value = i;
            node.next = null;
            preNode.next = node;
            preNode = node;
        }
    }

    public static LinkedNode reverse(LinkedNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        LinkedNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public String toString() {
        LinkedNode node = this.head;
        StringBuffer sb = new StringBuffer();
        while (node != null) {
            sb.append(node.value + "->");
            node = node.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList(10);
        System.out.println(ll);
        ll.head = reverse(ll.head);
        System.out.println(ll);
    }
}
