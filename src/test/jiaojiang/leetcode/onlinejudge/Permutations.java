package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: mizhang
 * @time: 2/2/15 10:48 PM
 */
public class Permutations {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            List<List<Integer>> expected = new ArrayList<List<Integer>>();

            expected.add(Utils.getList(new Integer[]{1, 2, 3}));
            expected.add(Utils.getList(new Integer[]{1, 3, 2}));
            expected.add(Utils.getList(new Integer[]{2, 1, 3}));
            expected.add(Utils.getList(new Integer[]{2, 3, 1}));
            expected.add(Utils.getList(new Integer[]{3, 1, 2}));
            expected.add(Utils.getList(new Integer[]{3, 2, 1}));

            Test.assertEquals(expected, (List<List<Integer>>) method.invoke(null, new int[]{1, 2, 3}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}


