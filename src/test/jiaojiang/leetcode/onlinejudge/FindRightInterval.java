package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 1/28/15 6:38 PM
 */
public class FindRightInterval {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[][].class);
            Test.assertEquals(new int[]{-1}, (int[]) method.invoke(null, (Object) new int[][]{{1, 2}}));
            Test.assertEquals(new int[]{-1, 0, 1}, (int[]) method.invoke(null, (Object) new int[][]{{3, 4}, {2, 3}, {1, 2}}));
            Test.assertEquals(new int[]{-1, 2, -1}, (int[]) method.invoke(null, (Object) new int[][]{{1, 4}, {2, 3}, {3, 4}}));
            Test.assertEquals(new int[]{0, -1}, (int[]) method.invoke(null, (Object) new int[][]{{1, 1}, {3, 4}}));


        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
