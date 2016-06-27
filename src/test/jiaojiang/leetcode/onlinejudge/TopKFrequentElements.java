package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author zhang
 *
 * Created on May 2, 2016
 */
public class TopKFrequentElements {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class, int.class);
            Test.assertEquals(new HashSet<Integer>(Arrays.asList(new Integer[]{1, 2})),
                    new HashSet<Integer>((List<Integer>)method.invoke(null, new int[]{1, 1, 1, 2, 2, 3}, 2)));
            Test.assertEquals(new HashSet<Integer>(Arrays.asList(Utils.getIntegerArray("TopKFrequentElements_Result.data"))),
                    new HashSet<Integer>((List<Integer>)method.invoke(null, Utils.getIntArray("TopKFrequentElements.data"), 143)));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
