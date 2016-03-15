package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Mar 14, 2016
 */
public class NumberOfDigitOne {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class);
            Test.assertEquals(1, method.invoke(null, 1));
            Test.assertEquals(6, method.invoke(null, 13));
            Test.assertEquals(146, method.invoke(null, 213));
            Test.assertEquals(141, method.invoke(null, 203));
            Test.assertEquals(153, method.invoke(null, 223));
            Test.assertEquals(1737167499, method.invoke(null, 1410065408));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
