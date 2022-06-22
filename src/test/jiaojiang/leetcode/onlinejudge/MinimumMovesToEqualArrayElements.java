package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MinimumMovesToEqualArrayElements {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            Test.assertEquals(3, method.invoke(null, new int[]{1, 2, 3}));
            Test.assertEquals(0, method.invoke(null, new int[]{1, 1, 1}));
            Test.assertEquals(300, method.invoke(null, new int[]{-100, 0, 100}));
            Test.assertEquals(5351828, method.invoke(null, Utils.getIntArray("MinimumMovesToEqualArrayElements.data")));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}





