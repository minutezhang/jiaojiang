package test.jiaojiang.leetcode.onlinejudge;

import companies.amazon.mitbbs.Lists;
import utils.Test;
import utils.TreeNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: mizhang
 * @time: 3/3/15 6:24 PM
 */
public class ConvertSortedArraytoBinarySearchTree {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            TreeNode bst = (TreeNode) method.invoke(null, new int[]{1, 3, 5, 7, 9, 10, 11, 12});
            List<Integer> expected = Arrays.asList(new Integer[]{1, 3, 5, 7, 9, 10, 11, 12});

            Test.assertEquals(expected, TreeNode.inorder(bst));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
