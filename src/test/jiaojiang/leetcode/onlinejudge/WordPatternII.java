package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Sep 12, 2016
 */
public class WordPatternII {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class, String.class);
            
            Test.assertTrue((Boolean)method.invoke(null, "abab", "redblueredblue"));
            Test.assertTrue((Boolean)method.invoke(null, "aaaa", "asdasdasdasd"));

            Test.assertFalse((Boolean)method.invoke(null, "aabb", "xyzabcxzyabc"));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
