package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 4/24/15 3:04 PM
 */
public class HouseRobber {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            Test.assertEquals(2, method.invoke(null, new int[]{1, 1, 1}));
            Test.assertEquals(0, method.invoke(null, new int[0]));
            Test.assertEquals(13, method.invoke(null, new int[]{1, 5, 4, 8}));
            Test.assertEquals(42, method.invoke(null, new int[]{1, 1, 3, 6, 7, 10, 7, 1, 8, 5, 9, 1, 4, 4, 3}));
            Test.assertEquals(39, method.invoke(null, new int[]{6, 3, 10, 8, 2, 10, 3, 5, 10, 5, 3}));
            Test.assertEquals(1082, method.invoke(null, new int[]{82, 217, 170, 215, 153, 55, 185, 55, 185, 232, 69, 131, 130, 102}));

            if (methodName.endsWith("DP")) {
                Test.assertEquals(4173, method.invoke(null, getNeighbors()));
            }
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }

    public static int[] getNeighbors() {
        return new int[]{114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144, 240};
    }
}
