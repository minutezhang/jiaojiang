package test.jiaojiang.leetcode.onlinejudge;

import utils.ListNode;
import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 2/27/15 3:54 PM
 */
public class ReverseLinkedListII {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, ListNode.class, int.class, int.class);
            ListNode head = ListNode.getSampleNode(5);
            ListNode expected = new ListNode(1);
            expected.next = new ListNode(4);
            expected.next.next = new ListNode(3);
            expected.next.next.next = new ListNode(2);
            expected.next.next.next.next = new ListNode(5);
            Test.assertEquals(expected, method.invoke(null, head, 2, 4));

            head = ListNode.getSampleNode(5);
            expected = ListNode.getSampleNode(5);
            Test.assertEquals(expected, method.invoke(null, head, 2, 2));

            Test.assertEquals(expected, method.invoke(null, head, 10, 12));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }

}
