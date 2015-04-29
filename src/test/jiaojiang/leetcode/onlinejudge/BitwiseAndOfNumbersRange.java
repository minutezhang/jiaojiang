package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: zhang
 * @date: Apr 23, 2015 9:36:12 PM
 */
public class BitwiseAndOfNumbersRange {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class, int.class);
            Test.assertEquals(4, method.invoke(null, 5, 7));
            Test.assertEquals(0, method.invoke(null, 0, 2147483647));
            Test.assertEquals(2147483647, method.invoke(null, 2147483647, 2147483647));
            Test.assertEquals(0, method.invoke(null, 700000000, 2147483641));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
