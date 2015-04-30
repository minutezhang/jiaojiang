package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhang
 * @date: Apr 29, 2015 10:47:02 PM
 */
public class PascalsTriangleII {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class);
            List<Integer> expected = new ArrayList<Integer>();
            expected.add(1);
            expected.add(3);
            expected.add(3);
            expected.add(1);

            Test.assertEquals(expected, method.invoke(null, 3));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
