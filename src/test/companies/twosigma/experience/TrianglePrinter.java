package test.companies.twosigma.experience;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: zhang
 * @date: Mar 23, 2015 9:05:17 PM
 */
public class TrianglePrinter {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, double.class);
            String expected = "x\n";
            Test.assertEquals(expected, method.invoke(null, 1));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
