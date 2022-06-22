package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CanIWin {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class, int.class);
//            Test.assertFalse((boolean)method.invoke(null, 10, 11));
//            Test.assertTrue((boolean)method.invoke(null, 10, 14));
//            Test.assertTrue((boolean)method.invoke(null, 10, 0));
//            Test.assertTrue((boolean)method.invoke(null, 10, 1));
//            Test.assertFalse((boolean)method.invoke(null, 10, 40));
//            Test.assertTrue((boolean)method.invoke(null, 11, 25));
//            Test.assertFalse((boolean)method.invoke(null, 20, 210));
//            Test.assertFalse((boolean)method.invoke(null, 18, 188));
            Test.assertFalse((boolean)method.invoke(null, 5, 50));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
