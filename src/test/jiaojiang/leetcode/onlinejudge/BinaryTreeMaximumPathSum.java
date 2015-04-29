package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.TreeNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 3/6/15 5:23 PM
 */
public class BinaryTreeMaximumPathSum {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, TreeNode.class);
            Test.assertEquals(18, method.invoke(null, TreeNode.getSampleTree()));
            Test.assertEquals(21, method.invoke(null, TreeNode.getSampleTree2()));
            Test.assertEquals(50, method.invoke(null, TreeNode.getSampleTree3()));
            Test.assertEquals(30, method.invoke(null, TreeNode.getSampleTree4()));
            Test.assertEquals(69, method.invoke(null, TreeNode.getSampleBinarySearchTree()));
            Test.assertEquals(58, method.invoke(null, TreeNode.getSampleBinarySearchTree2()));
            Test.assertEquals(83, method.invoke(null, TreeNode.getSampleBinarySearchTree3()));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
