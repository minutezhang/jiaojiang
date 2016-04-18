package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Mar 26, 2016
 */
public class WordPattern {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class, String.class);
            Test.assertTrue((Boolean)method.invoke(null, "abba", "dog cat cat dog"));

            Test.assertFalse((Boolean)method.invoke(null, "abba", "dog cat cat fish"));
            Test.assertFalse((Boolean)method.invoke(null, "jquery", "jquery"));
            Test.assertFalse((Boolean)method.invoke(null, "abba", "dog dog dog dog"));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
