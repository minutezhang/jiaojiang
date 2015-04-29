package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: mizhang
 * @time: 2/10/15 1:03 PM
 */
public class PermutationsII {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            List<List<Integer>> expected = new ArrayList<List<Integer>>();
            expected.add(Utils.getList(new Integer[]{1, 1, 1, 2}));
            expected.add(Utils.getList(new Integer[]{1, 1, 2, 1}));
            expected.add(Utils.getList(new Integer[]{1, 2, 1, 1}));
            expected.add(Utils.getList(new Integer[]{2, 1, 1, 1}));

            Test.assertEquals(expected, (List<List<Integer>>) method.invoke(null, new int[]{1, 1, 1, 2}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
