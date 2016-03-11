package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * @author zhang
 *
 * Created on Mar 6, 2016
 */
public class ExpressionAddOperators {
    /*
    "123", 6 -> ["1+2+3", "1*2*3"]
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
     */
    public static void test(String packageName, String className, String methodName)
            throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class, int.class);
//            Test.assertEquals(Arrays.asList(new String[]{"1+2+3", "1*2*3"}), method.invoke(null, "126", 6));
            Test.assertEquals(Arrays.asList(new String[]{"2*3+2", "2+3*2"}), (List<String>)method.invoke(null, "232", 8));
            Test.assertEquals(Arrays.asList(new String[]{"1*0+5","10-5"}), (List<String>)method.invoke(null, "105", 5));
//            Test.assertEquals(Arrays.asList(new String[]{"0+0", "0-0", "0*0"}), (List<String>)method.invoke(null, "00", 0));
//            Test.assertEquals(Arrays.asList(new String[0]), (List<String>)method.invoke(null, "3456237490", 9191));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
