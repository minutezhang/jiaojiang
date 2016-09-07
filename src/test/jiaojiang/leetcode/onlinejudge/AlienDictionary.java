package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Sep 4, 2016
 */
public class AlienDictionary {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String[].class);
            Test.assertEquals("wertf", method.invoke(null, (Object)new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
            Test.assertEquals("", method.invoke(null, (Object)new String[]{"wrt", "wrf", "er", "ett", "rftt", "wer"}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }    
}
