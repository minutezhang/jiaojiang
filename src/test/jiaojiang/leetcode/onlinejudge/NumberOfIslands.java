package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 4/24/15 5:03 PM
 */
public class NumberOfIslands {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, char[][].class);
            char[][] region = new char[][]{
                    "11110".toCharArray(),
                    "11010".toCharArray(),
                    "11000".toCharArray(),
                    "00000".toCharArray()
            };
            Test.assertEquals(1, method.invoke(null, (Object)region));

            region = new char[][]{
                    "11000".toCharArray(),
                    "11000".toCharArray(),
                    "00100".toCharArray(),
                    "00011".toCharArray()
            };
            Test.assertEquals(3, method.invoke(null, (Object)region));

            region = new char[][]{
                    "10111".toCharArray(),
                    "10101".toCharArray(),
                    "11101".toCharArray()
            };
            Test.assertEquals(1, method.invoke(null, (Object)region));

            Test.assertEquals(0, method.invoke(null, (Object)new char[0][0]));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
