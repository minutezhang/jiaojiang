package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: mizhang
 * @time: 3/3/15 9:52 PM
 */
public class Subsets {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            List<List<Integer>> expected = new ArrayList<List<Integer>>();
            expected.add(Utils.getList(new Integer[]{3}));
            expected.add(Utils.getList(new Integer[]{1}));
            expected.add(Utils.getList(new Integer[]{2}));
            expected.add(Utils.getList(new Integer[]{1, 2, 3}));
            expected.add(Utils.getList(new Integer[]{1, 3}));
            expected.add(Utils.getList(new Integer[]{2, 3}));
            expected.add(Utils.getList(new Integer[]{1, 2}));
            expected.add(Utils.getList(new Integer[]{}));
            
            Test.assertEquals(expected, (List)method.invoke(null, new int[]{3, 1, 2}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
