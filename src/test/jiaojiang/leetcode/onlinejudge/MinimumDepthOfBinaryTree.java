package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.TreeNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: zhang
 * @date: Feb 28, 2015 3:38:35 PM
 */
public class MinimumDepthOfBinaryTree {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, TreeNode.class);
            Test.assertEquals(3, method.invoke(null, TreeNode.getSampleTree()));
            Test.assertEquals(2, method.invoke(null, TreeNode.getSampleTree2()));
            Test.assertEquals(0, method.invoke(null, (Object) null));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
