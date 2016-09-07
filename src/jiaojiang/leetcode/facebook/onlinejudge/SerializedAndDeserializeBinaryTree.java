package jiaojiang.leetcode.facebook.onlinejudge;

import utils.TreeNode;

import java.util.Queue;
import java.util.LinkedList;


/**
 * @author zhang
 *
 * Created on Sep 5, 2016
 */
public class SerializedAndDeserializeBinaryTree {
    /*
    Serialization is the process of converting a data structure or object into a sequence of bits so that it can be
    stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in
    the same or another computer environment.

    Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
    serialization/deserialization algorithm should work. You just need to ensure that a binary tree can
    be serialized to a string and this string can be deserialized to the original tree structure.

    For example, you may serialize the following tree

        1
       / \
      2   3
         / \
        4   5

    as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily
    need to follow this format, so please be creative and come up with different approaches yourself.

    Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms
    should be stateless.
     */
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        
        StringBuilder data =  new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node == null) {
                data.append("#,");
            } else {
                data.append(node.val)
                        .append(',');
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        int length = data.length() - 1;
        for (; length >= 0 && data.charAt(length - 1) == '#' && data.charAt(length - 2) == ','; length -= 2);

        data.setLength(length);
        
        return data.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] dataNodes = data.split(",");

        if (dataNodes.length == 0 || "#".equals(dataNodes[0])) {
            return null;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(dataNodes[0]));
        queue.add(root);

        for (int i = 1; i < dataNodes.length; i += 2) {
            TreeNode node = queue.remove();
            if (!"#".equals(dataNodes[i])) {
                node.left = new TreeNode(Integer.parseInt(dataNodes[i]));
                queue.add(node.left);
            }

            if (i + 1 < dataNodes.length && !"#".equals(dataNodes[i + 1])) {
                node.right = new TreeNode(Integer.parseInt(dataNodes[i + 1]));
                queue.add(node.right);
            }
        }
        return root;
    }
}
