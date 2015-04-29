package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * @author: zhang
 * @date: Mar 9, 2015 11:57:00 PM
 */
public class ReadNCharactersGivenRead4 {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class, int.class);
            String filename = "/ReadNCharactersGivenRead4.data";
            String expected = expected(filename);
            Test.assertEquals(expected.substring(0, 10), method.invoke(null, filename, 10));
            Test.assertEquals(expected.substring(0, 100), method.invoke(null, filename, 100));
            Test.assertEquals(expected.substring(0, Math.min(expected.length(), 1000)), method.invoke(null, filename, 1000));
            Test.assertEquals(expected.substring(0, Math.min(expected.length(), 10000)), method.invoke(null, filename, 10000));
            Test.assertEquals(expected.substring(0, Math.min(expected.length(), 100000)), method.invoke(null, filename, 100000));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }

    private static String expected(String filename) {
        InputStream is = ReadNCharactersGivenRead4.class.getResourceAsStream(filename);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuffer ret = new StringBuffer();
        String line;
        try {
            while ((line = br.readLine()) != null) {
                ret.append(line).append("\n");
            }
            ret.setLength(ret.length() - 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ret.toString();
    }
}
