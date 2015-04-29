package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 2/10/15 6:10 PM
 */
public class EditDistance {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class, String.class);
            Test.assertEquals(0, method.invoke(null, "a", "a"));
            Test.assertEquals(1, method.invoke(null, "a", ""));
            Test.assertEquals(1, method.invoke(null, "", "a"));
            Test.assertEquals(3, method.invoke(null, "horse", "ros"));
            if (methodName.endsWith("DP")) {
                Test.assertEquals(6, method.invoke(null, "dinitrophenylhydrazine", "acetylphenylhydrazine"));
                Test.assertEquals(28, method.invoke(null, "pneumonoultramicroscopicsilicovolcanoconiosis", "ultramicroscopical"));
            }
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}

