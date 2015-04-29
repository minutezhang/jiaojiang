package companies.twosigma.mitbbs;

/**
 * @author: mizhang
 * @time: 2/12/15 10:05 PM
 */
public class Node {
    Node left, right;
    int data;
    Node(int newData) {
        left = right = null;
        data = newData;
    }

    public static Node getSampleTree() {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(5);

        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(6);

        return root;
    }

}
