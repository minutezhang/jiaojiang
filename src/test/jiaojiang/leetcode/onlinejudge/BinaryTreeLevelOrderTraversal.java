package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.TreeNode;
import utils.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: mizhang
 * @time: 3/6/15 6:27 PM
 */
public class BinaryTreeLevelOrderTraversal {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, TreeNode.class);
            List<List<Integer>> expected = new ArrayList<List<Integer>>();
            expected.add(Utils.getList(new Integer[]{1}));
            expected.add(Utils.getList(new Integer[]{2, 5}));
            expected.add(Utils.getList(new Integer[]{3, 4, 6}));
            Test.assertEquals(expected, (List<List<Integer>>) method.invoke(null, TreeNode.getSampleTree()));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
