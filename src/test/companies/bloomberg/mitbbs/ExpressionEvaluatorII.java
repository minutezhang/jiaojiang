package test.companies.bloomberg.mitbbs;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: zhang
 * @date: Mar 15, 2015 4:37:06 PM
 */
public class ExpressionEvaluatorII {
        public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class);
            Test.assertEquals(21, method.invoke(null,"10+2*6-1"));
            Test.assertEquals(212, method.invoke(null,"100*2+12"));
            Test.assertEquals(1400, method.invoke(null,"100*(2 +12)"));
            Test.assertEquals(100, method.invoke(null,"100*(2+12)/14"));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
