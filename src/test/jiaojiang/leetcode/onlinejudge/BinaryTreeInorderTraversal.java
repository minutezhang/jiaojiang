package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.TreeNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: mizhang
 * @time: 2/8/15 10:47 AM
 */
public class BinaryTreeInorderTraversal {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, TreeNode.class);

            List<Integer> expected = new ArrayList<Integer>();
            expected.add(3);
            expected.add(2);
            expected.add(4);
            expected.add(1);
            expected.add(5);
            expected.add(6);
            Test.assertEquals(expected, method.invoke(null, TreeNode.getSampleTree()));

            expected.clear();
            expected.add(6);
            expected.add(4);
            expected.add(3);
            expected.add(2);
            expected.add(1);
            expected.add(5);
            Test.assertEquals(expected, method.invoke(null, TreeNode.getSampleTree2()));

            expected.clear();
            expected.add(3);
            expected.add(4);
            expected.add(6);
            expected.add(7);
            expected.add(8);
            expected.add(11);
            expected.add(14);
            expected.add(19);
            expected.add(20);
            Test.assertEquals(expected, method.invoke(null, TreeNode.getSampleBinarySearchTree()));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
