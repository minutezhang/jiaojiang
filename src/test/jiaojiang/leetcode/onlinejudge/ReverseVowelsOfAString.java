package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

/**
 * @author zhang
 *
 * Created on Apr 25, 2016
 */
public class ReverseVowelsOfAString {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class);
            Test.assertEquals("holle", method.invoke(null, "hello"));
            Test.assertEquals("leotcede", method.invoke(null, "leetcode"));
            Test.assertEquals("Aa", method.invoke(null, "aA"));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
