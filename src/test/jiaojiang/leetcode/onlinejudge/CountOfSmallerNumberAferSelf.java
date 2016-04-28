package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author zhang
 *
 * Created on Mar 29, 2016
 */
public class CountOfSmallerNumberAferSelf {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            Test.assertEquals(Arrays.asList(new Integer[]{2, 1, 1, 0}), method.invoke(null, new int[]{5, 2, 6, 1}));
            Test.assertEquals(Arrays.asList(new Integer[]{2, 1, 1, 1, 1, 1, 0}), method.invoke(null, new int[]{5, 2, 6, 6, 6, 6, 1}));

            if (!"countSmaller".equals(methodName)) {
                long time = System.nanoTime();
                Test.assertEquals(Utils.toList(Utils.getData("CountOfSmallerNumberAfterSelf_Result.data")),
                        method.invoke(null, Utils.getData("CountOfSmallerNumberAfterSelf.data")));
                Utils.printElapsedTime(time, methodName);
            }
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }

}
