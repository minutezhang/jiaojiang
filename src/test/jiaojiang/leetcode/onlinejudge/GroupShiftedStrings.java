package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.ArrayList;

/**
 * @author zhang
 *
 * Created on Sep 14, 2016
 */
public class GroupShiftedStrings {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String[].class);
            List<List<String>> expected = new ArrayList<List<String>>();

            expected.add(Utils.getList(new String[]{"abc","bcd","xyz"}));
            expected.add(Utils.getList(new String[]{"az","ba"}));
            expected.add(Utils.getList(new String[]{"acef"}));
            expected.add(Utils.getList(new String[]{"a","z"}));

            Test.assertEquals(expected, (List<List<String>>)method.invoke(null, (Object)new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
