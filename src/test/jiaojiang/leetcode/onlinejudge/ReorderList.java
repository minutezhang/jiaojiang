package test.jiaojiang.leetcode.onlinejudge;

import utils.ListNode;
import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 1/29/15 3:06 PM
 */
public class ReorderList {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, ListNode.class);

            ListNode head = null;
            ListNode expected = null;
            method.invoke(null, head);
            Test.assertEquals(expected, head);

            head = ListNode.getSampleNode(4);
            expected = new ListNode(1);
            expected.next = new ListNode(4);
            expected.next.next = new ListNode(2);
            expected.next.next.next = new ListNode(3);
            method.invoke(null, head);
            Test.assertEquals(expected, head);

            head = ListNode.getSampleNode(5);
            expected = new ListNode(1);
            expected.next = new ListNode(5);
            expected.next.next = new ListNode(2);
            expected.next.next.next = new ListNode(4);
            expected.next.next.next.next = new ListNode(3);
            method.invoke(null, head);
            Test.assertEquals(expected, head);
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
