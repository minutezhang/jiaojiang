package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Aug 11, 2016
 */
public class FindKPairsWithSmallestSums {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class, int[].class, int.class);
            Test.assertEquals(Utils.getList(new int[][]{{1, 2}, {1, 4}, {1, 6}}),
                    method.invoke(null, new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
