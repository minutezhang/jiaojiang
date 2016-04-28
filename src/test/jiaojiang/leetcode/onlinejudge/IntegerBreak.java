package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Apr 19, 2016
 */
public class IntegerBreak {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class);
            Test.assertEquals(1, method.invoke(null, 2));
            Test.assertEquals(2, method.invoke(null, 3));
            Test.assertEquals(9, method.invoke(null, 6));
            Test.assertEquals(36, method.invoke(null, 10));
            long time = System.nanoTime();
            Test.assertEquals(2916, method.invoke(null, 22));
            Utils.printElapsedTime(time, methodName);
            time = System.nanoTime();
            Test.assertEquals(3188646, method.invoke(null, 41));
            Utils.printElapsedTime(time, methodName);
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
