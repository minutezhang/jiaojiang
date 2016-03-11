package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Feb 26, 2016
 */
public class AdditiveNumber {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class);
            Test.assertTrue((Boolean)method.invoke(null, "123"));
            Test.assertTrue((Boolean)method.invoke(null, "101"));
            Test.assertTrue((Boolean)method.invoke(null, "112358"));
            Test.assertTrue((Boolean)method.invoke(null, "199100199"));

            Test.assertFalse((Boolean)method.invoke(null, "0235813"));
            Test.assertFalse((Boolean)method.invoke(null, "1991000199299498797"));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
