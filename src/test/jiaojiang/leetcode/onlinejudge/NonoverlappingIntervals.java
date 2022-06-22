package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 1/28/15 6:38 PM
 */
public class NonoverlappingIntervals {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[][].class);
            Test.assertEquals(1, method.invoke(null, (Object) new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
            Test.assertEquals(2, method.invoke(null, (Object) new int[][]{{1, 2}, {1, 2}, {1, 2}}));
            Test.assertEquals(0, method.invoke(null, (Object) new int[][]{{1, 2}, {2, 3}}));
            Test.assertEquals(2, method.invoke(null, (Object) new int[][]{{0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}}));
            Test.assertEquals(7, method.invoke(null, (Object) new int[][]{{-52, 31}, {-73, -26}, {82, 97}, {-65, -11},
                    {-62, -49}, {95, 99}, {58, 95}, {-31, 49}, {66, 98}, {-63, 2}, {30, 47}, {-40, -26}}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
