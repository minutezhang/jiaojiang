package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 * 
 * Created on Feb 23, 2016
 */
public class IncreasingTripletSubsequence {
        public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            Test.assertTrue((Boolean)method.invoke(null, (Object)new int[]{1, 2, 3, 4, 5}));
            Test.assertTrue((Boolean)method.invoke(null, (Object)new int[]{5, 2, 3, 4, 1}));
            Test.assertTrue((Boolean)method.invoke(null, (Object)new int[]{2, 3, 1, 5, 4}));
            Test.assertTrue((Boolean)method.invoke(null, (Object)new int[]{2, 1, 5, 0, 4, 6}));

            Test.assertFalse((Boolean)method.invoke(null, (Object)new int[0]));
            Test.assertFalse((Boolean)method.invoke(null, (Object)new int[1]));
            Test.assertFalse((Boolean)method.invoke(null, (Object)new int[2]));
            Test.assertFalse((Boolean)method.invoke(null, (Object)new int[]{1, 1, -2, 6}));
            Test.assertFalse((Boolean)method.invoke(null, (Object)new int[]{5, 3, 4, 1, 2}));
            Test.assertFalse((Boolean)method.invoke(null, (Object)new int[]{5, 4, 3, 2, 1}));
            Test.assertFalse((Boolean)method.invoke(null, (Object)new int[]{4, 5, 3, 2, 1}));
            Test.assertFalse((Boolean)method.invoke(null, (Object)new int[]{4, 5, 2, 3, 1}));
            Test.assertFalse((Boolean)method.invoke(null, (Object)new int[]{2, 4, -2, -3}));
            Test.assertFalse((Boolean)method.invoke(null, (Object)new int[]{0, 4, 2, 1, 0, -1, -3}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
