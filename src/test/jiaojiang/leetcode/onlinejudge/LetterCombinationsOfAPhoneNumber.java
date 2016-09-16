package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: mizhang
 * @time: 3/3/15 3:44 PM
 */
public class LetterCombinationsOfAPhoneNumber {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class);
            List<String> expected = new ArrayList<String>();
            String[] combinations = new String[]{"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"};
            for (String s : combinations) {
                expected.add(s);
            }
            Test.assertEquals(expected, (List<String>)method.invoke(null, "23"));

            expected.clear();
            Test.assertEquals(expected, (List<String>)method.invoke(null, ""));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
