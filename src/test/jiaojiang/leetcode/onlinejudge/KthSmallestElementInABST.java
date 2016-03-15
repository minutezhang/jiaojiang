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
public class KthSmallestElementInABST {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, TreeNode.class, int.class);
            TreeNode root = new TreeNode(4);
            root.left = new TreeNode(2);
            root.left.left = new TreeNode(1);
            root.left.right = new TreeNode(3);

            root.right = new TreeNode(7);
            root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(9);

            Test.assertEquals(1, method.invoke(null, root, 1));
            Test.assertEquals(3, method.invoke(null, root, 3));
            Test.assertEquals(4, method.invoke(null, root, 4));
            Test.assertEquals(9, method.invoke(null, root, 7));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
