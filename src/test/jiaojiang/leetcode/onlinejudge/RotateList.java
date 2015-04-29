package test.jiaojiang.leetcode.onlinejudge;

import utils.ListNode;
import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 2/6/15 11:53 PM
 */
public class RotateList {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, ListNode.class, int.class);

            ListNode head = null;
            ListNode expected = null;
            Test.assertEquals(expected, method.invoke(null, head, 3));

            head = ListNode.getSampleNode(5);

            expected = new ListNode(4);
            expected.next = new ListNode(5);
            expected.next.next = new ListNode(1);
            expected.next.next.next = new ListNode(2);
            expected.next.next.next.next = new ListNode(3);
            Test.assertEquals(expected, method.invoke(null, head, 2));

            Test.assertEquals(ListNode.getSampleNode(1), method.invoke(null, ListNode.getSampleNode(1), 1));
            Test.assertEquals(ListNode.getSampleNode(2), method.invoke(null, ListNode.getSampleNode(2), 2));

        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
