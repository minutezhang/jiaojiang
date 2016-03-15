package test.jiaojiang.leetcode.onlinejudge;

import utils.TreeNode;
import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Mar 14, 2016
 */
public class LowestCommonAncestorOfABinaryTree {
        public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, TreeNode.class, TreeNode.class, TreeNode.class);
            TreeNode root = new TreeNode(4);
            root.left = new TreeNode(12);
            root.left.left = new TreeNode(1);
            root.left.right = new TreeNode(3);

            root.right = new TreeNode(2);
            root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(9);

            Test.assertEquals(root.left, method.invoke(null, root, root.left.left, root.left.right));
            Test.assertEquals(root, method.invoke(null, root, root.left.left, root.right.right));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
