package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.ArrayList;

/**
 * @author zhang
 *
 * Created on Sep 13, 2016
 */
public class FactorCombinations {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class);
            List<List<Integer>> expected = new ArrayList<List<Integer>>();
            Test.assertEquals(expected, method.invoke(null, 1));
            Test.assertEquals(expected, method.invoke(null, 37));

            expected.add(Utils.getList(new Integer[]{2, 6}));
            expected.add(Utils.getList(new Integer[]{2, 2, 3}));
            expected.add(Utils.getList(new Integer[]{3, 4}));
            Test.assertEquals(expected, (List<List<Integer>>)method.invoke(null, 12));

            expected.clear();
            expected.add(Utils.getList(new Integer[]{2, 16}));
            expected.add(Utils.getList(new Integer[]{2, 2, 8}));
            expected.add(Utils.getList(new Integer[]{2, 2, 2, 4}));
            expected.add(Utils.getList(new Integer[]{2, 2, 2, 2, 2}));
            expected.add(Utils.getList(new Integer[]{2, 4, 4}));
            expected.add(Utils.getList(new Integer[]{4, 8}));
            Test.assertEquals(expected, (List<List<Integer>>)method.invoke(null, 32));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}