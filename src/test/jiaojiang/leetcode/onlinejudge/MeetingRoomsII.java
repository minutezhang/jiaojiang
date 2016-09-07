package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.Interval;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Sep 3, 2016
 */
public class MeetingRoomsII {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, Interval[].class);
            Test.assertEquals(2, method.invoke(null, (Object)new Interval[]{new Interval(0, 30), new Interval(5, 10), new Interval(15, 20)}));
            Test.assertEquals(1, method.invoke(null, (Object)new Interval[]{new Interval(5, 10), new Interval(0, 3), new Interval(15, 20)}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
