package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author zhang
 * <p>
 * Created on Mar 22, 2022
 * <p>
 * nput: nums = [1,5,11,5]
 * * Output: true
 * * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * *
 * * Example 2:
 * *
 * * Input: nums = [1,2,3,5]
 * * Output: false
 * * Explanation: The array cannot be partitioned into equal sum subsets.
 * *
 * * Example 3:
 * * [100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
 * *  100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
 * *  100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
 * *  100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
 * *  100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
 * *  100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
 * *  100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
 * *  100,100,99,97]
 */
public class PartitionEqualSubsetSum {

    private static int[] getArray() {
        int[] array = new int[100];
        Arrays.fill(array, 100);
        array[98] = 99;
        array[99] = 97;
        return array;
    }

    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            Test.assertTrue((boolean)method.invoke(null, new int[]{1, 5, 11, 5}));
            Test.assertFalse((boolean)method.invoke(null, new int[]{1, 2, 3, 5}));
            Test.assertFalse((boolean)method.invoke(null, getArray()));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
