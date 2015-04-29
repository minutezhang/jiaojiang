package test.jiaojiang.leetcode.onlinejudge;

import utils.Utils;
import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.ArrayList;

/**
 * @author: zhang
 * @date: Apr 26, 2015 10:15:06 PM
 */
public class SubsetsII {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            List<List<Integer>> expected = new ArrayList<List<Integer>>();
            expected.add(Utils.getList(new Integer[]{2}));
            expected.add(Utils.getList(new Integer[]{1}));
            expected.add(Utils.getList(new Integer[]{1, 2, 2}));
            expected.add(Utils.getList(new Integer[]{2, 2}));
            expected.add(Utils.getList(new Integer[]{1, 2}));
            expected.add(Utils.getList(new Integer[]{}));

            Test.assertEquals(expected, (List)method.invoke(null, new int[]{2, 1, 2}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
