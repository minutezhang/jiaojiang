package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.TreeNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * @author zhang
 *
 * Created on Sep 6, 2016
 */
public class BinaryTreeVerticalOrderTraversal {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, TreeNode.class);
            List<List<Integer>> expected = new ArrayList<List<Integer>>();

/*
         1
        / \
       2   5
      / \   \
     3   4   6
*/
            expected.add(Arrays.asList(new Integer[]{3}));
            expected.add(Arrays.asList(new Integer[]{2}));
            expected.add(Arrays.asList(new Integer[]{1, 4}));
            expected.add(Arrays.asList(new Integer[]{5}));
            expected.add(Arrays.asList(new Integer[]{6}));
            Test.assertEquals(expected, method.invoke(null, TreeNode.getSampleTree()));
/*
            5
      /          \
     3           10
  /     \      /     \
 2       4     8     10
       /     /   \
      3     5    8
                  \
                   9
                  /
                 8
*/
            expected.clear();
            expected.add(Arrays.asList(new Integer[]{2}));
            expected.add(Arrays.asList(new Integer[]{3, 3, 5}));
            expected.add(Arrays.asList(new Integer[]{5, 4, 8}));
            expected.add(Arrays.asList(new Integer[]{10, 8, 8}));
            expected.add(Arrays.asList(new Integer[]{9, 10}));
            Test.assertEquals(expected, method.invoke(null, TreeNode.getSampleBinarySearchTree2()));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
