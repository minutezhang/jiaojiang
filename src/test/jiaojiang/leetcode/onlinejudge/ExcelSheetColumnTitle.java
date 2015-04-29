package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 2/14/15 10:55 PM
 */
public class ExcelSheetColumnTitle {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class);
            Test.assertEquals("AB", method.invoke(null, 28));
            Test.assertEquals("AA", method.invoke(null, 27));
            Test.assertEquals("B", method.invoke(null, 2));
            Test.assertEquals("Z", method.invoke(null, 26));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
