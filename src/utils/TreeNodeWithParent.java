package utils;

/**
 * @author: zhang
 * @date: Feb 24, 2015 12:34:35 AM
 */
public class TreeNodeWithParent extends TreeNode {

    public TreeNodeWithParent parent;

    public TreeNodeWithParent(int x) {
        super(x);
        parent = null;
    }
}
