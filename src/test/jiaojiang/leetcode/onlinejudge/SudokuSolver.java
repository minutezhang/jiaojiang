package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 2/11/15 10:49 PM
 */
public class SudokuSolver {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, char[][].class);
            char[][] board = getSudoku();
            method.invoke(null, (Object) board);
            Test.assertEquals(getSolution(), board);

            board = getSudoku2();
            method.invoke(null, (Object) board);
            Test.assertEquals(getSolution2(), board);

            board = getSudoku3();
            method.invoke(null, (Object) board);
            Test.assertEquals(getSolution3(), board);

        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }

    private static char[][] getSudoku() {
        return new char[][] {
            "53..7....".toCharArray(), 
            "6..195...".toCharArray(), 
            ".98....6.".toCharArray(), 
            "8...6...3".toCharArray(), 
            "4..8.3..1".toCharArray(), 
            "7...2...6".toCharArray(), 
            ".6....28.".toCharArray(), 
            "...419..5".toCharArray(), 
            "....8..79".toCharArray()
        };
    }

    private static char[][] getSolution() {
        return new char[][]{
                "534678912".toCharArray(), 
                "672195348".toCharArray(), 
                "198342567".toCharArray(), 
                "859761423".toCharArray(), 
                "426853791".toCharArray(), 
                "713924856".toCharArray(), 
                "961537284".toCharArray(), 
                "287419635".toCharArray(), 
                "345286179".toCharArray()
        };
    }


    private static char[][] getSudoku2() {
        return new char[][] {
                "..9748...".toCharArray(), 
                "7........".toCharArray(), 
                ".2.1.9...".toCharArray(), 
                "..7...24.".toCharArray(), 
                ".64.1.59.".toCharArray(), 
                ".98...3..".toCharArray(), 
                "...8.3.2.".toCharArray(), 
                "........6".toCharArray(), 
                "...2759..".toCharArray()
        };
    }

    private static char[][] getSolution2() {
        return new char[][]{
                "519748632".toCharArray(), 
                "783652419".toCharArray(), 
                "426139875".toCharArray(), 
                "357986241".toCharArray(), 
                "264317598".toCharArray(), 
                "198524367".toCharArray(), 
                "975863124".toCharArray(), 
                "832491756".toCharArray(), 
                "641275983".toCharArray()
        };
    }

    private static char[][] getSudoku3() {
        return new char[][]{
                "8........".toCharArray(), 
                "..36.....".toCharArray(), 
                ".7..9.2..".toCharArray(), 
                ".5...7...".toCharArray(), 
                "....457..".toCharArray(), 
                "...1...3.".toCharArray(), 
                "..1....68".toCharArray(), 
                "..85...1.".toCharArray(), 
                ".9....4..".toCharArray(), 
        };
    }

    private static char[][] getSolution3() {
        return new char[][]{
                "812753649".toCharArray(), 
                "943682175".toCharArray(), 
                "675491283".toCharArray(), 
                "154237896".toCharArray(), 
                "369845721".toCharArray(), 
                "287169534".toCharArray(), 
                "521974368".toCharArray(), 
                "438526917".toCharArray(), 
                "796318452".toCharArray()
        };
    }
}
