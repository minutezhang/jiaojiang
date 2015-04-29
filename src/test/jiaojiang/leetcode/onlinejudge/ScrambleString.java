package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 3/4/15 7:19 PM
 */
public class ScrambleString {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class, String.class);
            Test.assertTrue((Boolean) method.invoke(null, "rgtae", "great"));
            Test.assertTrue((Boolean) method.invoke(null, "rgeat", "great"));
            Test.assertFalse((Boolean) method.invoke(null, "abcdefghijklmnopq", "efghijklmnopqcadb"));
            if (methodName.endsWith("DP")) {
                Test.assertFalse((Boolean) method.invoke(null, "ccabcbabcbabbbbcbb", "bbbbabccccbbbabcba"));
            }
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
