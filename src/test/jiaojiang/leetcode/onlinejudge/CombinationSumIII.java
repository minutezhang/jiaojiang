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
 * Created on Jul 27, 2016
 */
public class CombinationSumIII {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class, int.class);
            List<List<Integer>> expected = new ArrayList<List<Integer>>();
            expected.add(Utils.getList(new Integer[]{1, 2, 4}));
            Test.assertEquals(expected, (List<List<Integer>>)method.invoke(null, 3, 7));

            expected.clear();
            expected.add(Utils.getList(new Integer[]{1, 2, 6}));
            expected.add(Utils.getList(new Integer[]{1, 3, 5}));
            expected.add(Utils.getList(new Integer[]{2, 3, 4}));
            Test.assertEquals(expected, (List<List<Integer>>)method.invoke(null, 3, 9));

            expected.clear();
            Test.assertEquals(expected, (List<List<Integer>>)method.invoke(null, 2, 18));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
