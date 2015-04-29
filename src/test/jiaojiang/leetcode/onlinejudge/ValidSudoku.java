package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 2/10/15 11:36 AM
 */
public class ValidSudoku {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, char[][].class);
            Test.assertFalse((Boolean) method.invoke(null, (Object) getInvalidSudoku()));
            Test.assertTrue((Boolean) method.invoke(null, (Object) getValidSudoku()));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }

    private static char[][] getInvalidSudoku() {
        return new char[][]{
                ".1...1...".toCharArray(), 
                ".........".toCharArray(), 
                ".........".toCharArray(), 
                ".........".toCharArray(), 
                ".........".toCharArray(), 
                ".........".toCharArray(), 
                ".........".toCharArray(), 
                ".........".toCharArray(), 
                ".........".toCharArray()
        };
    }

    private static char[][] getValidSudoku() {
        return new char[][] {
                ".87654321".toCharArray(), 
                "2........".toCharArray(), 
                "3........".toCharArray(), 
                "4........".toCharArray(), 
                "5........".toCharArray(), 
                "6........".toCharArray(), 
                "7........".toCharArray(), 
                "8........".toCharArray(), 
                "9........".toCharArray()
        };
    }
}
