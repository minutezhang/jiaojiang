package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.TreeNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: zhang
 * @date: Feb 21, 2015 6:17:55 PM
 */
public class RecoverBinarySearchTree {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, TreeNode.class);
            TreeNode bst = TreeNode.getSampleBinarySearchTree();
            swapVal(bst.right, bst.left);
            method.invoke(null, bst);
            Test.assertEquals(TreeNode.getSampleBinarySearchTree(), bst);


            bst = TreeNode.getSampleBinarySearchTree();
            swapVal(bst.left, bst.left.left);
            method.invoke(null, bst);
            Test.assertEquals(TreeNode.getSampleBinarySearchTree(), bst);

            bst = TreeNode.getSampleBinarySearchTree();
            swapVal(bst.left, bst.left.right);
            method.invoke(null, bst);
            Test.assertEquals(TreeNode.getSampleBinarySearchTree(), bst);
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }

    private static void swapVal(TreeNode node1, TreeNode node2) {
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }
}
