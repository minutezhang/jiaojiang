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
 * @time: 2/2/15 10:06 PM
 */
public class PathSumII {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, TreeNode.class, int.class);
            List<List<Integer>> expected = new ArrayList<List<Integer>>();
            expected.add(Utils.getList(new Integer[]{1, 2, 3}));

            Test.assertEquals(expected, (List<List<Integer>>) method.invoke(null, TreeNode.getSampleTree(), 6));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
