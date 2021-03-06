package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.ListNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Mar 8, 2016
 */
public class ReverseLinkedList {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, ListNode.class);

            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);

            ListNode expected = new ListNode(4);
            expected.next = new ListNode(3);
            expected.next.next = new ListNode(2);
            expected.next.next.next = new ListNode(1);

            Test.assertEquals(expected, method.invoke(null, head));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
