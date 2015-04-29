package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.*;

/**
 * @author: zhang
 * @since: May 12, 2013 12:31:53 AM
 */
public class GenerateParentheses {
    /*
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

    For example, given n = 3, a solution set is:

    "((()))", "(()())", "(())()", "()(())", "()()()"
     */

    /*
    solution (WRONG):
    case 1: second is '('
        1.1 (( ...... )), then (......) is n - 1 ---- ( ())(() ) is a counter example
        1.2 (( ...... (), then ((...... is n - 1
    case 2 : second is ')'
        () ......, then ...... is n - 1
     */
//    public static ArrayList<String> generateParenthesis(int n) {
//        ArrayList<String> ret = new ArrayList<String>();
//        ret.add("()");
//
//        ArrayList<String> next = new ArrayList<String>();
//        for (int i = 1; i < n; i++) {
//            for (String s : ret) {
//                if (s.startsWith("((")) {
//                    next.add(s + "()");
//                }
//                next.add("()" + s);
//                next.add("(" + s +  ")");
//            }
//
//            ArrayList<String> tmp = next;
//            next = ret;
//            ret = tmp;
//            next.clear();
//        }
//
//        return ret;
//    }

    /*
    solution: imaging an (n + 1) X (n + 1) matrix M with starting index 0, ending index n, the valid parenthese is represented
    by a path from (0, 0) to (n, n) in the upper triangle submatrix (the number of '(' in any subsequence starting at begin
    must have more '(' then ')') and at each position (i, j), it can move either upward 
    or rightward (adding a '(' or ')')

     */

    public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("");

        return generateParenthesis(0, 0, list, n);
    }

    public static ArrayList<String> generateParenthesis2(int n) {
        ArrayList<String> list = new ArrayList<String>();
        generateParenthesis(0, 0, list, n, "");
        return list;
    }

    public static ArrayList<String> generateParenthesis3(int n) {
        ArrayList<String> list = new ArrayList<String>();
        generateParenthesis(0, 0, list, n, new StringBuffer());
        return list;
    }

    public static ArrayList<String> generateParenthesis(int openBrace, int closeBrace, ArrayList<String> list, int n) {

        ArrayList<String> ret = new ArrayList<String>();

        if (openBrace == closeBrace) {
            if (openBrace == n) {
                return list;
            }

            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i) + "(");
            }
            return generateParenthesis(openBrace + 1, closeBrace, list, n);
        }

        ArrayList<String> rightList = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            rightList.add(list.get(i) + ")");
            list.set(i, list.get(i) + "(");
        }

        if (openBrace < n) {
            ret.addAll(generateParenthesis(openBrace + 1, closeBrace, list, n));
        }

        if (closeBrace < n) {
            ret.addAll(generateParenthesis(openBrace, closeBrace + 1, rightList, n));
        }

        return ret;
    }

    public static void generateParenthesis(int openBrace, int closeBrace, ArrayList<String> list, int n, String s) {
        if (openBrace == closeBrace && openBrace == n) {
            list.add(s.toString());
            return ;
        }

        if (closeBrace > openBrace) {
            return;
        }

        if (openBrace < n) {
//            s += '(';
//            generateParenthesis(openBrace + 1, closeBrace, list, n, s);
            generateParenthesis(openBrace + 1, closeBrace, list, n, s + '(');
        }

        if (closeBrace < n) {
//            s += ')';
//            generateParenthesis(openBrace, closeBrace + 1, list, n, s);
            generateParenthesis(openBrace, closeBrace + 1, list, n, s + ')');
        }
    }

    public static void generateParenthesis(int openBrace, int closeBrace, ArrayList<String> list, int n, StringBuffer s) {
        if (openBrace == closeBrace && openBrace == n) {
            list.add(s.toString());
            return ;
        }

        if (closeBrace > openBrace) {
            return;
        }

        if (openBrace < n) {
            generateParenthesis(openBrace + 1, closeBrace, list, n, s.append('('));
            s.setLength(s.length()  - 1);
        }

        if (closeBrace < n) {
            generateParenthesis(openBrace, closeBrace + 1, list, n, s.append(')'));
            s.setLength(s.length()  - 1);
        }
    }

    public static void test() {
//        String[] s4 = new String[] {
//                "(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"
//        };
//
//        Set<String> set = new HashSet<String>();
//
//        for (String s : generateParenthesis(4)) {
//            set.add(s);
//        }
//
//        for (String s : s4) {
//            if (!set.contains(s)) {
//                System.out.printTestln(s);
//            }
//        }

        for (String  s : generateParenthesis(3)) {
            System.out.print(s + " ");
        }
        System.out.println();

        for (String  s : generateParenthesis2(3)) {
            System.out.print(s + " ");
        }
        System.out.println();

        for (String  s : generateParenthesis3(3)) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        test();
    }
}
