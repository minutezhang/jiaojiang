package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: mizhang
 * @time: 2/27/15 11:16 AM
 */
public class PalindromPartitioning {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class);
            List<List<String>> expected = new ArrayList<List<String>>();
            expected.add(Utils.getList(new String[]{"aa", "b"}));
            expected.add(Utils.getList(new String[]{"a", "a", "b"}));
            Test.assertEquals(expected, (List<List<String>>)method.invoke(null, "aab"));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
