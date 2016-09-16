package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

/**
 * @author zhang
 *
 * Created on Sep 15, 2016
 */
public class ReverseWordsInAStringII {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, char[].class);
            char[] string = "the sky is blue".toCharArray();
            method.invoke(null, string);
            Test.assertEquals("blue is sky the", new String(string));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
