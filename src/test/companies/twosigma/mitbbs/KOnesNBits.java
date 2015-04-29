package test.companies.twosigma.mitbbs;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.ArrayList;

/**
 * @author: zhang
 * @date: Mar 19, 2015 7:31:15 PM
 */
public class KOnesNBits {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class, int.class);
            List<Integer> expected = new ArrayList<Integer>();

            expected.add(1);
            expected.add(2);
            expected.add(4);
            Test.assertEquals(expected, method.invoke(null, 1, 3));

            expected.clear();
            expected.add(3);
            expected.add(5);
            expected.add(6);
            Test.assertEquals(expected, method.invoke(null, 2, 3));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
