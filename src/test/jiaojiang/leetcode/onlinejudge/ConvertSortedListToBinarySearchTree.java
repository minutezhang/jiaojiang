package test.jiaojiang.leetcode.onlinejudge;

import utils.TreeNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import utils.ListNode;
import utils.Test;

/**
 * @author: mizhang
 * @time: 2/8/15 10:25 AM
 */
public class ConvertSortedListToBinarySearchTree {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, ListNode.class);

            ListNode head = null;
            TreeNode expected = null;

            Test.assertEquals(expected, method.invoke(null, head));

            head = ListNode.getSampleNode(4);
            TreeNode root = (TreeNode) method.invoke(null, head);
            Test.assertTrue(TreeNode.isBinarySearchTree(root));
            Test.assertTrue(TreeNode.isHeightBalanced(root));
            Test.assertEquals(head, TreeNode.inorder(root));

            head = ListNode.getSampleNode(5);
            root = (TreeNode) method.invoke(null, head);
            Test.assertTrue(TreeNode.isBinarySearchTree(root));
            Test.assertTrue(TreeNode.isHeightBalanced(root));
            Test.assertEquals(head, TreeNode.inorder(root));

        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
