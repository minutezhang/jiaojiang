package utils;

/**
 * @author: mizhang
 * @since: Nov 29, 2014 7:17:19 AM
 */
public class ListNode {
    public int val;
    public ListNode next;
    
    public ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode getSampleNode() {
        ListNode root = new ListNode(4);
        root.next = new ListNode(2);

        root.next.next = new ListNode(5);
        root.next.next.next = new ListNode(1);
        root.next.next.next.next = new ListNode(3);

        return root;
    }

    public static ListNode getSampleNode(int length) {
        return getSampleNode(1, length);
    }

    public static ListNode getSampleNode(int start, int length) {
        if (length == 0) {
            return null;
        }

        ListNode root = new ListNode(start);
        ListNode pre = root;
        for (int i = 1; i < length; i++) {
            pre.next = new ListNode(start + i);
            pre = pre.next;
        }

        return root;
    }

    /*
    A:          a1 ? a2
                       ?
                         c1 ? c2 ? c3
                       ?
    B:     b1 ? b2 ? b3
    */
    public static ListNode getIntersectedLinkedList(ListNode node) {
        ListNode root = new ListNode(11);
        root.next = new ListNode(12);

        root.next.next = new ListNode(13);
        root.next.next.next = node;

        return root;
    }

    public static ListNode getSampleNodeWithCycle() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);

        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = root.next.next;

        return root;
    }

    public static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val+ " -> ");
            node = node.next;
        }
        System.out.println("null");
    }

    @Override
    public String toString() {
        StringBuffer ret = new StringBuffer();
        ListNode node = this;
        while ( node != null) {
            ret.append(node.val+ " -> ");
            node = node.next;
        }
        ret.append("null");
        return ret.toString();
    }

    public boolean equals(Object anotherList) {
        return this.getClass() == anotherList.getClass() && isListsEqual(this, (ListNode) anotherList);
    }

    public static boolean isListsEqual(ListNode list, ListNode anotherList) {
        for (ListNode node = list, node2 = anotherList; ; node = node.next, node2 = node2.next) {
            if (node == null && node2 == null) {
                return true;
            }

            if (node == null || node2 == null) {
                return false;
            }

            if (node.val != node2.val) {
                return false;
            }
        }
    }

    public static ListNode remove(ListNode head, int value) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        for (ListNode node = dummyHead; node.next != null; node = node.next) {
            if (node.next.val == value) {
                node.next = node.next.next;
            }
        }

        return dummyHead.next;
    }

    public static ListNode appendList(ListNode list, ListNode anotherList) {
        if (list == null) {
            return anotherList;
        }

        ListNode node = list;
        for(; node.next != null; node = node.next);
        node.next = anotherList;
        return list;
    }

    public static void main(String[] args) {
        ListNode root = getSampleNode();
        print(root);

        print(getIntersectedLinkedList(root.next.next));
    }
}
