package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author zhang
 *
 * Created on Apr 27, 2016
 */
public class TheSkylineProblem {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[][].class);
            List<int[]> expected = Utils.getList(new int[][]{{2, 10}, {3, 15}, {7, 12}, {12, 0}, {15, 10}, {20, 8}, {24, 0}});
            int[][] heights = new int[][] {
                    {2, 9, 10},
                    {3, 7, 15},
                    {5, 12, 12},
                    {15, 20, 10},
                    {19, 24, 8}
            };
            Test.assertEquals(expected, method.invoke(null, heights));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }    
}
