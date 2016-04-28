package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Arrays;

import jiaojiang.leetcode.practice4.onlinejudge.FlattenNestedListIterator.NestedInteger;
import sun.jvm.hotspot.utilities.Assert;

/**
 * @author zhang
 *
 * Created on Apr 21, 2016
 */
public class FlattenNestedListIterator {
    private static class NestedIntegerImpl implements NestedInteger {

        private Integer nestedInteger;
        private List<NestedInteger> list;

        public NestedIntegerImpl(Integer nestedInteger) {
            this.nestedInteger = nestedInteger;
        }

        public NestedIntegerImpl(NestedInteger... nestedIntegers) {
            list = Arrays.asList(nestedIntegers);
        }

        @Override
        public boolean isInteger() {
            return nestedInteger != null;
        }

        @Override
        public Integer getInteger() {
            return nestedInteger;
        }

        @Override
        public List<NestedInteger> getList() {
            return list;
        }
    }

    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        NestedInteger nestedInteger
                = new NestedIntegerImpl(new NestedIntegerImpl(new NestedIntegerImpl(1), new NestedIntegerImpl(1)),
                            new NestedIntegerImpl(2),
                            new NestedIntegerImpl(new NestedIntegerImpl(1), new NestedIntegerImpl(1))
                    );

        jiaojiang.leetcode.practice4.onlinejudge.FlattenNestedListIterator iterator
                = new jiaojiang.leetcode.practice4.onlinejudge.FlattenNestedListIterator(nestedInteger);

        int[] expected = new int[] {1, 1, 2, 1, 1};
        for (int i = 0; i < expected.length; i++) {
            Test.assertTrue(iterator.hasNext());
            int next = iterator.next();
            Test.assertEquals(expected[i], next);
        }

        nestedInteger = new NestedIntegerImpl(new NestedIntegerImpl
                            (new NestedIntegerImpl(1),
                                   new NestedIntegerImpl(new NestedIntegerImpl(4),
                                       new NestedIntegerImpl(new NestedIntegerImpl(6))
                                   )
                             )
                        );

        iterator = new jiaojiang.leetcode.practice4.onlinejudge.FlattenNestedListIterator(nestedInteger);

        expected = new int[] {1, 4, 6};
        for (int i = 0; i < expected.length; i++) {
            Test.assertTrue(iterator.hasNext());
            int next = iterator.next();
            Test.assertEquals(expected[i], next);
        }
    }
}
