package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Jun 23, 2016
 */
public class HouseRobberII {
        public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            Test.assertEquals(1, method.invoke(null, new int[]{1, 1, 1}));
            Test.assertEquals(1, method.invoke(null, new int[]{1}));
            Test.assertEquals(0, method.invoke(null, new int[0]));
            Test.assertEquals(13, method.invoke(null, new int[]{1, 5, 4, 8}));
            Test.assertEquals(41, method.invoke(null, new int[]{1, 1, 3, 6, 7, 10, 7, 1, 8, 5, 9, 1, 4, 4, 3}));
            Test.assertEquals(36, method.invoke(null, new int[]{6, 3, 10, 8, 2, 10, 3, 5, 10, 5, 3}));
            Test.assertEquals(1082, method.invoke(null, new int[]{82, 217, 170, 215, 153, 55, 185, 55, 185, 232, 69, 131, 130, 102}));
            Test.assertEquals(2926, method.invoke(null, new int[]{94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61, 6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397, 52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
