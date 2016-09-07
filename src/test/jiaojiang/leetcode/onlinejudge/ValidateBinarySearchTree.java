package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.TreeNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Aug 30, 2016
 */
public class ValidateBinarySearchTree {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, TreeNode.class);
            Test.assertFalse((Boolean)method.invoke(null, TreeNode.getSampleTree()));
            Test.assertFalse((Boolean)method.invoke(null, TreeNode.getSampleTree2()));
            Test.assertTrue((Boolean)method.invoke(null, TreeNode.getSampleBinarySearchTree()));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
    
}
