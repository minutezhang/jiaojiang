package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author zhang
 *
 * Created on Mar 15, 2016
 */
public class DifferentWaysToAddParentheses {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class);

            Test.assertEquals(new HashSet<Integer>(Arrays.asList(new Integer[]{11})), new HashSet<Integer>((List<Integer>)method.invoke(null, "11")));
            Test.assertEquals(new HashSet<Integer>(Arrays.asList(new Integer[]{0, 2})), new HashSet<Integer>((List<Integer>)method.invoke(null, "2-1-1")));
            Test.assertEquals(new HashSet<Integer>(Arrays.asList(new Integer[]{-34, -14, -10, -10, 10})), new HashSet<Integer>((List<Integer>)method.invoke(null, "2*3-4*5")));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
