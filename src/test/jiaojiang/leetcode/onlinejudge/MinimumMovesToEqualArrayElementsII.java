package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MinimumMovesToEqualArrayElementsII {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            Test.assertEquals(2, method.invoke(null, new int[]{1, 2, 3}));
            Test.assertEquals(2, method.invoke(null, new int[]{1, 3, 2}));
            Test.assertEquals(16, method.invoke(null, new int[]{1, 10, 2, 9}));
            Test.assertEquals(2127271182, method.invoke(null, new int[]{203125577,-349566234,230332704,48321315,66379082,386516853,50986744,-250908656,-425653504,-212123143}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}





