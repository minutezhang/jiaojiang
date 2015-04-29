package test.jiaojiang.leetcode.onlinejudge;

import utils.ListNode;
import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 3/3/15 10:06 PM
 */
public class ReverseNodesInKGroup {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, ListNode.class, int.class);

            ListNode expected = new ListNode(3);
            expected.next = new ListNode(2);
            expected.next.next = new ListNode(1);
            expected.next.next.next = new ListNode(4);
            expected.next.next.next.next = new ListNode(5);
            Test.assertEquals(expected, method.invoke(null, ListNode.getSampleNode(5), 3));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }

}
