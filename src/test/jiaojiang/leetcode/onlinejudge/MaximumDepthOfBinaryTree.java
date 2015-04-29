package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.TreeNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 1/30/15 9:25 PM
 */
public class MaximumDepthOfBinaryTree {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, TreeNode.class);
            Test.assertEquals(3, method.invoke(null, TreeNode.getSampleTree()));
            Test.assertEquals(5, method.invoke(null, TreeNode.getSampleTree2()));
            Test.assertEquals(3, method.invoke(null, TreeNode.getSampleTree3()));
            Test.assertEquals(4, method.invoke(null, TreeNode.getSampleBinarySearchTree()));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
