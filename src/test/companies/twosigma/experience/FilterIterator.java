package test.companies.twosigma.experience;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 3/24/15 2:47 PM
 */
public class FilterIterator {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, Integer[].class);
            Test.assertTrue((Boolean)method.invoke(null, (Object)new Integer[]{1, 3, 5, 18, 7, 15, 10, 88, 1998, 23, 17, 0}));
            Test.assertTrue((Boolean)method.invoke(null, (Object)new Integer[]{5, 30, 5, 15, 0, 15, 10, 80, 1990}));
            Test.assertTrue((Boolean)method.invoke(null, (Object)new Integer[]{5, 30, 5, 18, 7, 15, 10, 88, 1998}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
