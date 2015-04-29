package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: mizhang
 * @time: 3/16/15 11:29 PM
 */
public class ThreeSum {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            List<List<Integer>> expected = new ArrayList<List<Integer>>();
            expected.add(Utils.getList(new Integer[]{-1, 0, 1}));
            expected.add(Utils.getList(new Integer[]{-1, -1, 2}));

            Test.assertEquals(expected, (List<List<Integer>>)method.invoke(null, new int[]{-1, 0, 1, 2, -1, -4}));
            
            expected.clear();
            expected.add(Utils.getList(new Integer[]{-2, 0, 2}));
            Test.assertEquals(expected, (List<List<Integer>>)method.invoke(null, new int[]{-2, 0, 0, 2, 2}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
