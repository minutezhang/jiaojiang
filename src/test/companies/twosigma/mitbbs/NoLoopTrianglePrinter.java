package test.companies.twosigma.mitbbs;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: zhang
 * @date: Mar 21, 2015 11:09:19 PM
 */
public class NoLoopTrianglePrinter {

        public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class);
            String expected = "*****\n" +
            "****\n" +
            "***\n" +
            "**\n" +
            "*";

            Test.assertEquals(expected, method.invoke(null, 5));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
