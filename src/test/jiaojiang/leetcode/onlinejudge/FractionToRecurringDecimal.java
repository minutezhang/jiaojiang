package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 2/14/15 11:38 PM
 */
public class FractionToRecurringDecimal {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class, int.class);
            Test.assertEquals("0.5", method.invoke(null, 1, 2));
            Test.assertEquals("2", method.invoke(null, 2, 1));
            Test.assertEquals("0.(6)", method.invoke(null, 2, 3));
            Test.assertEquals("0.(142857)", method.invoke(null, 1, 7));
            Test.assertEquals("0.(0588235294117647)", method.invoke(null, 1, 17));
            Test.assertEquals("0.(027)", method.invoke(null, 1, 37));
            Test.assertEquals("0.1(6)", method.invoke(null, 1, 6));
            Test.assertEquals("0", method.invoke(null, 0, 6));
            Test.assertEquals("-6.25", method.invoke(null, -50, 8));
            Test.assertEquals("-6.25", method.invoke(null, 50, -8));
            Test.assertEquals("6.25", method.invoke(null, -50, -8));
            Test.assertEquals("0.0000000004656612873077392578125", method.invoke(null, -1, -2147483648));
            String expected = "0.00(000000465661289042462740251655654056577585848337359161441621040707904997124914069194026549138227660723878669455195477065427143370461252966751355553982241280310754777158628319049732085502639731402098131932683780538602845887105337854867197032523144157689601770377165713821223802198558308923834223016478952081795603341592860749337303449725)";
            Test.assertEquals(expected, method.invoke(null, 1, 214748364));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
