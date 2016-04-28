package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.Utils;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

/**
 * @author zhang
 *
 * Created on Apr 10, 2016
 */
public class CreateMaximumNumber {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class, int[].class, int.class);
            Test.assertEquals(new int[]{9, 8, 6, 5, 3}, (int[]) method.invoke(null, new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5));
            Test.assertEquals(new int[]{6, 7, 6, 0, 4}, (int[]) method.invoke(null, new int[]{6, 7}, new int[]{6, 0, 4}, 5));
            Test.assertEquals(new int[]{9, 8, 9}, (int[]) method.invoke(null, new int[]{3, 9}, new int[]{8, 9}, 3));
            if (methodName.endsWith("Opt")) {
                long time = System.nanoTime();
                Test.assertEquals(new int[]{9, 8, 8, 8, 7, 6, 2, 3},
                        (int[]) method.invoke(null, new int[]{5, 9, 3, 7, 5, 6, 2, 3}, new int[]{3, 8, 1, 2, 8, 6, 0, 8}, 8));
                Utils.printElapsedTime(time, methodName);

                time = System.nanoTime();
                Test.assertEquals(new int[]{7, 3, 8, 2, 5, 6, 4, 4, 0, 6, 5, 7, 6, 2, 0},
                        (int[]) method.invoke(null, new int[]{2, 5, 6, 4, 4, 0}, new int[]{7, 3, 8, 0, 6, 5, 7, 6, 2}, 15));
                Utils.printElapsedTime(time, methodName);

                if (methodName.endsWith("2Opt")) {
                    time = System.nanoTime();
                    Test.assertEquals(Utils.getData("CreateMaximumNumber_Result.data"),
                            (int[]) method.invoke(null, Utils.getData("CreateMaximumNumber1.data"),
                                    Utils.getData("CreateMaximumNumber2.data"), 500));
                    Utils.printElapsedTime(time, methodName);
                }
            }
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
