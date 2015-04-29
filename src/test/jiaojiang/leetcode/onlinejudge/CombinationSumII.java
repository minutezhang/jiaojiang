package test.jiaojiang.leetcode.onlinejudge;

import utils.Utils;
import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.ArrayList;

/**
 * @author: zhang
 * @date: Apr 28, 2015 2:33:29 PM
 */
public class CombinationSumII {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class, int.class);
            List<List<Integer>> expected = new ArrayList<List<Integer>>();
            expected.add(Utils.getList(new Integer[]{1, 7}));
            expected.add(Utils.getList(new Integer[]{1, 2, 5}));
            expected.add(Utils.getList(new Integer[]{2, 6}));
            expected.add(Utils.getList(new Integer[]{1, 1, 6}));
            Test.assertEquals(expected, (List)method.invoke(null, new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
