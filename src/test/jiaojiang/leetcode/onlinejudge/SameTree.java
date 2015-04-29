package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.TreeNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 2/2/15 9:54 PM
 */
public class SameTree {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, TreeNode.class, TreeNode.class);
            Test.assertTrue((Boolean) method.invoke(null, TreeNode.getSampleTree(), TreeNode.getSampleTree()));
            Test.assertFalse((Boolean) method.invoke(null, TreeNode.getSampleTree(), TreeNode.getSampleTree2()));
            Test.assertTrue((Boolean) method.invoke(null, TreeNode.getSampleTree3(), TreeNode.getSampleTree3()));
            Test.assertTrue((Boolean) method.invoke(null, TreeNode.getSampleBinarySearchTree(), TreeNode.getSampleBinarySearchTree()));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
