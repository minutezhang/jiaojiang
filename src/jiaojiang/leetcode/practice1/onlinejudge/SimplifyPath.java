package jiaojiang.leetcode.practice1.onlinejudge;

import java.util.Stack;

/**
 * @author: mizhang@akamai.com
 */
public class SimplifyPath {
    /*
    Given an absolute path for a file (Unix-style), simplify it.

    For example,
    path = "/home/", => "/home"
    path = "/a/./b/../../c/", => "/c"
    */
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] inNodes = path.split("/");

        for (String s : inNodes) {
            if (s.equals(".") || s.isEmpty()) {
                continue;
            }

            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        String ret = "";
        while (!stack.isEmpty()) {
            ret = "/" + stack.pop() + ret;
        }

        return ret;
    }

    public static void test() {
        System.out.println(simplifyPath("/home/"));  // /home
        System.out.println(simplifyPath("/a/./b/../../c/")); // /c
        System.out.println(simplifyPath("/.hidden")); // /.hidden
    }

    public static void main(String[] args) {
        test();
    }
}
