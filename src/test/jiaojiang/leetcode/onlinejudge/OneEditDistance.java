package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Sep 1, 2016
 */
public class OneEditDistance {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class, String.class);
            Test.assertTrue((Boolean)method.invoke(null, "abcde", "abcdeX"));
            Test.assertTrue((Boolean)method.invoke(null, "abcde", "abXde"));
            Test.assertTrue((Boolean)method.invoke(null, "abcdeX", "abcde"));
            Test.assertTrue((Boolean)method.invoke(null, "a", ""));
            Test.assertTrue((Boolean)method.invoke(null, "", "a"));
            Test.assertTrue((Boolean)method.invoke(null, "aaaaaaaaa", "aaaaaaaaaa"));
            Test.assertFalse((Boolean)method.invoke(null, "a", "aaa"));
            Test.assertFalse((Boolean)method.invoke(null, "", "aa"));
            Test.assertFalse((Boolean)method.invoke(null, "dinitrophenylhydrazine", "acetylphenylhydrazine"));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }

}
