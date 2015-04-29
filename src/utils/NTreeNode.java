package utils;

import java.util.List;
import java.util.ArrayList;

/**
 * @author: mizhang
 * @since: Nov 27, 2013 1:43:49 PM
 */
public class NTreeNode {
    public int value;
    public List<NTreeNode> children;

    public NTreeNode(int value) {
        this.value = value;
        children = null;
    }

    public void addChild(NTreeNode childNode) {
        if (children == null) {
            children = new ArrayList<NTreeNode>();
        }

        children.add(childNode);
    }

    public static NTreeNode constructSampleTree() {
        NTreeNode root = new NTreeNode(0);

        root.addChild(new NTreeNode(1));
        root.addChild(new NTreeNode(2));
        root.addChild(new NTreeNode(3));

        root.children.get(0).addChild(new NTreeNode(5));
        root.children.get(0).addChild(new NTreeNode(6));
        root.children.get(0).addChild(new NTreeNode(7));
        root.children.get(0).addChild(new NTreeNode(8));

        root.children.get(1).addChild(new NTreeNode(9));

        root.children.get(2).addChild(new NTreeNode(10));

        root.children.get(0).children.get(2).addChild(new NTreeNode(12));

        return root;
    }
}
