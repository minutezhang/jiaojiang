package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 2/10/15 10:40 PM
 */
public class DecodeWays {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class);
            Test.assertEquals(2, method.invoke(null, "12"));
            Test.assertEquals(3, method.invoke(null, "123"));
            Test.assertEquals(2, method.invoke(null, "132"));
            Test.assertEquals(1, method.invoke(null, "201"));
            Test.assertEquals(0, method.invoke(null, ""));
            Test.assertEquals(0, method.invoke(null, "0"));
            Test.assertEquals(1, method.invoke(null, "27"));
            Test.assertEquals(1, method.invoke(null, "99"));
            Test.assertEquals(1, method.invoke(null, "10"));
            Test.assertEquals(1769472, method.invoke(null, "7541387519572282368613553811323167125532172369624572591562685959575371877973171856836975137559677665"));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
