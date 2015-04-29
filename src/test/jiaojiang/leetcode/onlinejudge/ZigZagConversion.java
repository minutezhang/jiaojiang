package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 3/3/15 12:12 PM
 */
public class ZigZagConversion {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class, int.class);
            Test.assertEquals("PAHNAPLSIIGYIR", method.invoke(null, "PAYPALISHIRING", 3));
            Test.assertEquals("PAYPALISHIRING", method.invoke(null, "PAYPALISHIRING", 1));
            Test.assertEquals("ABCED", method.invoke(null, "ABCDE", 4));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
