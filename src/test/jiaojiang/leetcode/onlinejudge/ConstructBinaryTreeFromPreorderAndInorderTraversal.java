package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.TreeNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 2/6/15 11:27 PM
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class, int[].class);
            TreeNode expected = TreeNode.getSampleTree();

            Test.assertEquals(expected, method.invoke(null, new int[]{1, 2, 3, 4, 5, 6}, new int[]{3, 2, 4, 1, 5, 6}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
