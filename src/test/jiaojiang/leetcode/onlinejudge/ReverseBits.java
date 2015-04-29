package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

/**
 * @author: zhang
 * @date: Mar 7, 2015 9:13:58 PM
 */
public class ReverseBits {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class);
            
            Test.assertEquals(964176192, method.invoke(null, 43261596));
            Test.assertEquals(-2130706432, method.invoke(null, 129));
            Test.assertEquals(1 << 30, method.invoke(null, 2));
            Test.assertEquals(1766832161, method.invoke(null, -2078412138));
            Test.assertEquals(2098807684, method.invoke(null, 566401214));
            Test.assertEquals(137365204, method.invoke(null, 727714832));
            Test.assertEquals(-1762479934, method.invoke(null, 1124945769));
            Test.assertEquals(-1837752280, method.invoke(null, 335834697));
            Test.assertEquals(-337042081, method.invoke(null, -89876521));
            Test.assertEquals(801057814, method.invoke(null, 1748303348));
            Test.assertEquals(-930357901, method.invoke(null, -826552045));
            Test.assertEquals(649440741, method.invoke(null, -1481265820));
            Test.assertEquals(256622458, method.invoke(null, 1593692912));

        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
