package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zhang
 *
 * Created on Feb 28, 2016
 */
public class MinimumHeightTrees {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class, int[][].class);
            List<Integer> expected = new ArrayList<Integer>();
            expected.add(0);
            Test.assertEquals(expected, method.invoke(null, 1, new int[][]{}));

            expected.clear();
            expected.add(1);
            Test.assertEquals(expected, method.invoke(null, 4, new int[][]{{1, 0}, {1, 2}, {1, 3}}));

            expected.clear();
            expected.addAll(Arrays.asList(new Integer[]{3, 4}));
            Test.assertEquals(expected, method.invoke(null, 6, new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
