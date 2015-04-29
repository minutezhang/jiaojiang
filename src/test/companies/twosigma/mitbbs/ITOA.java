package test.companies.twosigma.mitbbs;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: zhang
 * @date: Mar 22, 2015 8:29:56 PM
 */
public class ITOA {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, char[].class, int.class, int.class, char.class);
            int length = 5;
            char[] buf = new char[length];

            Test.assertTrue((Boolean)method.invoke(null, buf, length, 345, '@'));
            Test.assertEquals("@@345", new String(buf));

            Test.assertTrue((Boolean)method.invoke(null, buf, length, 12345, '@'));
            Test.assertEquals("12345", new String(buf));

            Test.assertTrue((Boolean)method.invoke(null, buf, length, 0, '@'));
            Test.assertEquals("@@@@0", new String(buf));

            Test.assertFalse((Boolean)method.invoke(null, buf, length, 123456, '@'));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
