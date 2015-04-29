package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: mizhang
 * @time: 2/6/15 11:03 PM
 */
public class GrayCode {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class);
            List<Integer> expected = new ArrayList<Integer>();
            expected.add(0);
            expected.add(1);
            expected.add(3);
            expected.add(2);

            Test.assertEquals(expected, method.invoke(null, 2));

            expected.clear();
            expected.add(0);
            Test.assertEquals(expected, method.invoke(null, 0));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
