package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhang
 * @date: Mar 5, 2015 9:35:22 PM
 */
public class SubstringWithConcatenationOfAllWords {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class, String[].class);
            List<Integer> expected = new ArrayList<Integer>();
            expected.add(0);
            expected.add(9);
            Test.assertEquals(expected, method.invoke(null, "barfoothefoobarman", new String[]{"foo", "bar"}));

            expected.clear();
            expected.add(0);
            Test.assertEquals(expected, method.invoke(null, "a", new String[]{"a"}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
