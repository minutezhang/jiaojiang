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
public class SummaryRange {
        public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);

            Test.assertEquals(Arrays.asList(new String[]{}), method.invoke(null, new int[0]));
            Test.assertEquals(Arrays.asList(new String[]{"1", "3"}), method.invoke(null, new int[]{1, 3}));
            Test.assertEquals(Arrays.asList(new String[]{"0->2","4->5","7"}), method.invoke(null, new int[]{0, 1, 2, 4, 5, 7}));
            Test.assertEquals(Arrays.asList(new String[]{"0->2","4->5","7->8"}), method.invoke(null, new int[]{0, 1, 2, 4, 5, 7, 8}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }

}
