package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Sep 7, 2016
 */
public class WildcardMatching {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class, String.class);
            Test.assertFalse((Boolean)method.invoke(null, "aa","a"));
            Test.assertFalse((Boolean)method.invoke(null, "aab","c*a*b*"));
            Test.assertFalse((Boolean)method.invoke(null, "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b"));

            Test.assertTrue((Boolean)method.invoke(null, "aa","aa"));
            Test.assertTrue((Boolean)method.invoke(null, "aa","*"));
            Test.assertTrue((Boolean)method.invoke(null, "aa","a*"));
            Test.assertTrue((Boolean)method.invoke(null, "ab","?*"));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
