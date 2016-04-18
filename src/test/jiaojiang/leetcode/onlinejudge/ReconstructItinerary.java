package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author zhang
 *
 * Created on Mar 27, 2016
 */
public class ReconstructItinerary {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String[][].class);
            Test.assertEquals(Arrays.asList(new String[]{"JFK", "MUC", "LHR", "SFO", "SJC"}), method.invoke(null, (Object)new String[][]{
                    {"MUC", "LHR"},
                    {"JFK", "MUC"},
                    {"SFO", "SJC"},
                    {"LHR", "SFO"}
            }));

            Test.assertEquals(Arrays.asList(new String[]{"JFK","ATL","JFK","SFO","ATL","SFO"}), method.invoke(null, (Object)new String[][]{
                    {"JFK", "SFO"},
                    {"JFK", "ATL"},
                    {"SFO", "ATL"},
                    {"ATL", "JFK"},
                    {"ATL", "SFO"}
            }));

            Test.assertEquals(Arrays.asList(new String[]{"JFK", "NRT", "JFK", "KUL"}), method.invoke(null, (Object)new String[][]{
                    {"JFK","KUL"},
                    {"JFK","NRT"},
                    {"NRT","JFK"}
            }));
            
            Test.assertEquals(Arrays.asList(new String[]{"JFK", "ANU", "EZE", "AXA", "TIA", "ANU", "JFK", "TIA", "ANU", "TIA", "JFK"}), method.invoke(null, (Object)new String[][]{
                    {"EZE", "AXA"},
                    {"TIA", "ANU"},
                    {"ANU", "JFK"},
                    {"JFK", "ANU"},
                    {"ANU", "EZE"},
                    {"TIA", "ANU"},
                    {"AXA", "TIA"},
                    {"TIA", "JFK"},
                    {"ANU", "TIA"},
                    {"JFK", "TIA"}
            }));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
