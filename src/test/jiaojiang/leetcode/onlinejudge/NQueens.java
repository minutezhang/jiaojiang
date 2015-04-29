package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhang
 * @date: Mar 22, 2015 4:48:23 PM
 */
public class NQueens {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class);
            List<String[]> expected = new ArrayList<String[]>();
            expected.add(new String[]{".Q..", "...Q", "Q...", "..Q."});
            expected.add(new String[]{"..Q.", "Q...", "...Q", ".Q.."});
            Test.assertEquals(convert(expected), convert((List<String[]>)method.invoke(null, 4)));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }

    private static List<String> convert(List<String[]> src) {
        List<String> ret = new ArrayList<String>();
        for (String[] ss : src) {
            String ts = "";
            for (String s : ss) {
                ts += s;
            }
            ret.add(ts);
        }

        return ret;
    }
}
