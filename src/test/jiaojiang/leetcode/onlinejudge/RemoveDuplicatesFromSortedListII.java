package test.jiaojiang.leetcode.onlinejudge;

import utils.ListNode;
import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 2/5/15 10:21 PM
 */
public class RemoveDuplicatesFromSortedListII {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, ListNode.class);

            // 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5    ===> 1 -> 2 -> 5
            ListNode node = new ListNode(1);
            node.next = new ListNode(2);
            node.next.next = new ListNode(3);
            node.next.next.next = new ListNode(3);
            node.next.next.next.next = new ListNode(4);
            node.next.next.next.next.next = new ListNode(4);
            node.next.next.next.next.next.next = new ListNode(5);

            ListNode expected = new ListNode(1);
            expected.next = new ListNode(2);
            expected.next.next = new ListNode(5);

            Test.assertEquals(expected, method.invoke(null, node));


            //1 -> 1 -> 1 -> 2 -> 3    ===> 2 -> 3
            node = new ListNode(1);
            node.next = new ListNode(1);
            node.next.next = new ListNode(1);
            node.next.next.next = new ListNode(2);
            node.next.next.next.next = new ListNode(3);

            expected = new ListNode(2);
            expected.next = new ListNode(3);

            Test.assertEquals(expected, method.invoke(null, node));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }

}
