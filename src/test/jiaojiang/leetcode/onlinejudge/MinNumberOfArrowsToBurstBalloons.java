package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MinNumberOfArrowsToBurstBalloons {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[][].class);
            Test.assertEquals(2, method.invoke(null, (Object) new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
            Test.assertEquals(4, method.invoke(null, (Object) new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}));
            Test.assertEquals(2, method.invoke(null, (Object) new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}));
            Test.assertEquals(2, method.invoke(null, (Object) new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
