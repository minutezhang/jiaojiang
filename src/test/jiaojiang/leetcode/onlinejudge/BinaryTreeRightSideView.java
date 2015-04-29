package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.TreeNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhang
 * @date: Apr 26, 2015 12:37:49 AM
 */
public class BinaryTreeRightSideView {
     public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, TreeNode.class);

            TreeNode tree = TreeNode.getSampleTree();

            List<Integer> expected = new ArrayList<Integer>();
            expected.add(1);
            expected.add(5);
            expected.add(6);
            Test.assertEquals(expected, method.invoke(null, tree));

            tree = TreeNode.getSampleTree2();
            expected.clear();
            expected.add(1);
            expected.add(5);
            expected.add(3);
            expected.add(4);
            expected.add(6);
            Test.assertEquals(expected, method.invoke(null, tree));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
