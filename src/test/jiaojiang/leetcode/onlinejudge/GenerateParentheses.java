package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: mizhang
 * @time: 2/9/15 4:39 PM
 */
public class GenerateParentheses {

    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
    try {
        Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class);
        List<String> expected = new ArrayList<String>();

        expected.add("((()))");
        expected.add("(()())");
        expected.add("(())()");
        expected.add("()(())");
        expected.add("()()()");

        Test.assertEquals(expected, (List<String>) method.invoke(null, 3));
    } catch (Exception e) {
        System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
        e.printStackTrace();
    }
}
}
