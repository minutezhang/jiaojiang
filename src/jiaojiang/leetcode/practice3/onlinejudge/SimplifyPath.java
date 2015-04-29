package jiaojiang.leetcode.practice3.onlinejudge;

import java.util.Stack;

/**
 * @author: zhang
 * @date: Mar 15, 2015 11:08:33 PM
 */
public class SimplifyPath {
    /*
    Given an absolute path for a file (Unix-style), simplify it.

    For example,
    path = "/home/", => "/home"
    path = "/a/./b/../../c/", => "/c"

    click to show corner cases.
    Corner Cases:

    Did you consider the case where path = "/../"?
    In this case, you should return "/".
    Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
    In this case, you should ignore redundant slashes and return "/home/foo".
     */
    public static String simplifyPath(String path) {
        String[] iNodes = path.split("/");
        Stack<String> stack = new Stack<String>();

        for (int i = 0; i < iNodes.length; i++) {
            if (!".".equals(iNodes[i]) && !"".equals(iNodes[i])) {
                if ("..".equals(iNodes[i])) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    stack.add(iNodes[i]);
                }
            }
        }

        String ret = stack.isEmpty() ? "" : stack.pop();
        while (!stack.isEmpty()) {
            ret = stack.pop() + "/" + ret;
        }

        return "/" + ret;
    }
}
