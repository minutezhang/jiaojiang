package companies.shareaholic.experience;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * @author: zhang
 * @since: Oct 1, 2013 9:27:27 PM
 */
/*
Assume you are given an dependecy tree:
                          A
                   /             \
                  B               C
            /          \       /      \
           D           E      F        G
        /    \
      H       I
            /   \
           J     K

 which means A depends on B, B depends on D and E, ...
 There are two functions given in for the Tree Node class
 interface Node {
     Node getParent();
     List<Node> getChildren();
 }

 Then given the root node, design you iterator class
 */

    //NOTE: reverse preorder traverse?
public class DependencyLib {

    public static void main(String[] args){
        NodeIterator iterator = new NodeIterator(Node.getSampleTree());
        while (iterator.hasNext()) {
            System.out.println(iterator.next().val);
        }

    }

    private static class NodeIterator implements Iterator<Node> {

        private Node current;

        public NodeIterator(Node root) {
            Node node = root;
            while (node.getChildren() != null) {
                node = node.getChildren().get(0);
            }
            current = node;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Node next() {
            Node node = current, parent = current.getParent();
            if (parent == null) {
                current = null;
                return node;
            }

            int i = 0;
            List<Node> children = parent.getChildren();

            while (i < children.size() && current != children.get(i)) {
                i++;
            }

            if (i == children.size() - 1) {
                current = parent;
                return node;
            }

            current = children.get(i + 1);
            while (current.getChildren() != null) {
                current = current.getChildren().get(0);
            }

            return node;
        }

        @Override
        public void remove() {
            next();
        }
    }

    private static class Node {
        char val;
        List<Node> children;
        Node parent;

        public Node(char c) {
            val = c;
            parent = null;
            children = null;
        }

        public Node getParent() {
            return parent;
        }

        public List<Node> getChildren() {
            return children;
        }

        private void addChild(Node child) {
            if (children == null) {
                children = new ArrayList<Node>();
            }
            children.add(child);
            child.parent = this;
        }

        public static Node getSampleTree() {
            Node root = new Node('A');

            root.addChild(new Node('B'));
            root.addChild(new Node('C'));

            root.getChildren().get(0).addChild(new Node('D'));
            root.getChildren().get(0).addChild(new Node('E'));

            root.getChildren().get(1).addChild(new Node('F'));
            root.getChildren().get(1).addChild(new Node('G'));

            root.getChildren().get(0).getChildren().get(0).addChild(new Node('H'));
            root.getChildren().get(0).getChildren().get(0).addChild(new Node('I'));

            root.getChildren().get(0).getChildren().get(0).getChildren().get(1).addChild(new Node('J'));
            root.getChildren().get(0).getChildren().get(0).getChildren().get(1).addChild(new Node('K'));

            return root;
        }
    }
}