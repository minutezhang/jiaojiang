package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.TreeNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Mar 26, 2016
 */
public class HouseRobberIII {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, TreeNode.class);
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(4);
            root.right = new TreeNode(5);

            root.left.left = new TreeNode(1);
            root.left.right = new TreeNode(3);

            root.right.right = new TreeNode(1);

            Test.assertEquals(9, method.invoke(null, root));

            Test.assertEquals(4, method.invoke(null, root.left));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}