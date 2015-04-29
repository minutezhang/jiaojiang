package test.jiaojiang.leetcode.onlinejudge;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.ArrayList;

import utils.Test;
import utils.ListNode;

/**
 * @author: zhang
 * @date: Mar 19, 2015 4:32:52 PM
 */
public class MergeKSortedLists {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, List.class);
            List<ListNode> lists = new ArrayList<ListNode>();
            ListNode list1 = new ListNode(1);
            list1.next = new ListNode(5);
            list1.next.next = new ListNode(9);
            list1.next.next.next = new ListNode(17);
            lists.add(list1);

            ListNode list2 = new ListNode(2);
            list2.next = new ListNode(8);
            list2.next.next = new ListNode(16);
            list2.next.next.next = new ListNode(18);
            lists.add(list2);

            ListNode list3 = new ListNode(3);
            list3.next = new ListNode(4);
            list3.next.next = new ListNode(6);
            list3.next.next.next = new ListNode(12);
            lists.add(list3);

            ListNode expected = new ListNode(1);
            expected.next = new ListNode(2);
            expected.next.next = new ListNode(3);
            expected.next.next.next = new ListNode(4);
            expected.next.next.next.next = new ListNode(5);
            expected.next.next.next.next.next = new ListNode(6);
            expected.next.next.next.next.next.next = new ListNode(8);
            expected.next.next.next.next.next.next.next = new ListNode(9);
            expected.next.next.next.next.next.next.next.next = new ListNode(12);
            expected.next.next.next.next.next.next.next.next.next = new ListNode(16);
            expected.next.next.next.next.next.next.next.next.next.next = new ListNode(17);
            expected.next.next.next.next.next.next.next.next.next.next.next = new ListNode(18);

            Test.assertEquals(expected, method.invoke(null, (List<ListNode>)lists));

            expected = null;
            lists.clear();
            Test.assertEquals(expected, method.invoke(null, lists));

            expected = null;
            lists.clear();
            lists.add(null);
            Test.assertEquals(expected, method.invoke(null, lists));

        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
