package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Feb 26, 2016
 */
public class BullsAndCows {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class, String.class);
            Test.assertEquals("1A1B", method.invoke(null, "1123", "0111"));
            Test.assertEquals("1A3B", method.invoke(null, "1807", "7810"));
            Test.assertEquals("0A4B", method.invoke(null, "1122", "2211"));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
