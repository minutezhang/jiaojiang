package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 2/27/15 10:31 AM
 */
public class EvaluateReversePolishNotation {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String[].class);
            Test.assertEquals(9, method.invoke(null, (Object) new String[]{"2", "1", "+", "3", "*"}));
            Test.assertEquals(6, method.invoke(null, (Object) new String[]{"4", "13", "5", "/", "+"}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }

}


