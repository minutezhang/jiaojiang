package test.jiaojiang.leetcode.onlinejudge;

import utils.TreeNode;
import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: zhang
 * @date: Apr 26, 2015 9:57:16 PM
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
        public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class, int[].class);
            TreeNode expected = TreeNode.getSampleTree();

            Test.assertEquals(expected, method.invoke(null, new int[]{3, 2, 4, 1, 5, 6}, new int[]{3, 4, 2, 6, 5, 1}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
