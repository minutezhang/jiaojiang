package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author zhang
 *
 * Created on Mar 14, 2016
 */
public class MajorityElementII {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);

            Test.assertEquals(Arrays.asList(new Integer[]{1}), method.invoke(null, new int[]{1}));
            Test.assertEquals(Arrays.asList(new Integer[]{3}), method.invoke(null, new int[]{3, 2, 3}));
            Test.assertEquals(Arrays.asList(new Integer[]{7}), method.invoke(null, new int[]{7, 11, 8, 7, 9, 10, 7, 10, 8, 7}));
            Test.assertEquals(Arrays.asList(new Integer[]{}), method.invoke(null, new int[]{10, 11, 8, 7, 9, 10, 7, 10, 8, 7}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
