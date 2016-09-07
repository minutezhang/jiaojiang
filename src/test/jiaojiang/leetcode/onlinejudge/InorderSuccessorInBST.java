package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.TreeNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Sep 3, 2016
 */
public class InorderSuccessorInBST {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, TreeNode.class, TreeNode.class);
            TreeNode root = TreeNode.getSampleBinarySearchTree();
            Test.assertEquals(root.right.right, method.invoke(null, root, root.right));
            Test.assertEquals(root, method.invoke(null, root, root.left.right.right));
            Test.assertEquals(root.left, method.invoke(null, root, root.left.left));
            Test.assertEquals(null, method.invoke(null, root, root.right.right));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
