package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

/**
 * @author: zhang
 * @date: Mar 9, 2015 11:22:35 PM
 */
public class NumberOfOneBits {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class);
            
            Test.assertEquals(3, method.invoke(null, 11));
            Test.assertEquals(32, method.invoke(null, -1));
            Test.assertEquals(15, method.invoke(null, -1797215335));
            Test.assertEquals(15, method.invoke(null, -441275374));
            Test.assertEquals(19, method.invoke(null, 1885845758));
            Test.assertEquals(17, method.invoke(null, 118351349));
            Test.assertEquals(13, method.invoke(null, -1596168088));

        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }    
}
