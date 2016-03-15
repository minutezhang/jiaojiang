package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.TreeNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Mar 14, 2016
 */
public class InvertBinaryTree {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, TreeNode.class);
            TreeNode root = new TreeNode(4);
            root.left = new TreeNode(2);
            root.left.left = new TreeNode(1);
            root.left.right = new TreeNode(3);

            root.right = new TreeNode(7);
            root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(9);

            TreeNode expected = new TreeNode(4);
            expected.left = new TreeNode(7);
            expected.left.left = new TreeNode(9);
            expected.left.right = new TreeNode(6);

            expected.right = new TreeNode(2);
            expected.right.left = new TreeNode(3);
            expected.right.right = new TreeNode(1);

            Test.assertEquals(expected, method.invoke(null, root));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
