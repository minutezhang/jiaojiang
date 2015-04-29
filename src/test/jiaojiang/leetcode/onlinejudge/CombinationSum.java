package test.jiaojiang.leetcode.onlinejudge;

import utils.Utils;
import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.ArrayList;

/**
 * @author: zhang
 * @date: Apr 28, 2015 10:16:24 AM
 */
public class CombinationSum {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class, int.class);
            List<List<Integer>> expected = new ArrayList<List<Integer>>();
            expected.add(Utils.getList(new Integer[]{2, 2, 3}));
            expected.add(Utils.getList(new Integer[]{7}));
            Test.assertEquals(expected, (List)method.invoke(null, new int[]{2, 3, 6, 7}, 7));

            expected = new ArrayList<List<Integer>>();
            expected.add(Utils.getList(new Integer[]{3, 4, 4}));
            expected.add(Utils.getList(new Integer[]{3, 8}));
            expected.add(Utils.getList(new Integer[]{4, 7}));
            Test.assertEquals(expected, (List)method.invoke(null, new int[]{8, 7, 4, 3}, 11));



        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
