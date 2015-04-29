package companies.bloomberg.experience;

import utils.Pair;
import utils.TreeNode;

import java.util.*;

/**
 * @author: mizhang
 * @time: 3/25/15 1:09 PM
 */
public class ConstructTreeFromPair {
    /*
    Given a list of pairs: (1, 2), (2, 5), ..., (3, 6), which is the (parent, child) of a binary tree, construct the tree
    form this list of pairs
     */
    public static TreeNode construct(List<Pair<Integer>> nodes) {
        Set<TreeNode> root = new HashSet<TreeNode>();
        Set<TreeNode> children = new HashSet<TreeNode>();
        Map<Integer, TreeNode> map = new HashMap<Integer, TreeNode>();

        for (Pair<Integer> p : nodes) {
            TreeNode parent, child;
            if (map.containsKey(p.left)) {
                parent = map.get(p.left);
            } else {
                parent = new TreeNode(p.left);
                map.put(p.left, parent);
            }

            if (map.containsKey(p.right)) {
                child = map.get(p.right);
            } else {
                child = new TreeNode(p.right);
                map.put(p.right, child);
            }

            if (parent.left == null) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            if (!root.contains(parent) && !children.contains(parent)) {
                root.add(parent);
            }

            if (root.contains(child)) {
                root.remove(child);
            }
            if (!children.contains(child)) {
                children.add(child);
            }
        }

        if (root.size() != 1) {
            return null;
        }

        return root.toArray(new TreeNode[0])[0];
    }
}
