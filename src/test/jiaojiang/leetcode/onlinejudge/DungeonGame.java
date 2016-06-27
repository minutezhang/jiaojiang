package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Jun 1, 2016
 */
public class DungeonGame {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[][].class);


            Test.assertEquals(4, method.invoke(null, (Object)new int[][]{{0, -3}}));

            Test.assertEquals(7, method.invoke(null, (Object)new int[][]{
                    {-2, -3, 3},
                    {-5, -10, 1},
                    {10, 30, -5}
            }));

            if (methodName.endsWith("Dp")) {
                Test.assertEquals(85, method.invoke(null, (Object) Utils.get2DIntArray("DungeonGame.data")));
            }
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    } 
}
