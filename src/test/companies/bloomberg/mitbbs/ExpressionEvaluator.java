package test.companies.bloomberg.mitbbs;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: zhang
 * @date: Mar 15, 2015 4:36:56 PM
 */
public class ExpressionEvaluator {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class);
            Test.assertEquals(200, method.invoke(null,"12+5*62/2-3+6*6"));
            Test.assertEquals(20, method.invoke(null,"4-2+6*3"));
            Test.assertEquals(3, method.invoke(null,"1+2"));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
