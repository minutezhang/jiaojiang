package jiaojiang.leetcode.facebook.onlinejudge;

import java.util.Stack;

/**
 * @author zhang
 *
 * Created on Aug 29, 2016
 */
public class SimplifyPath {
    /*
    Given an absolute path for a file (Unix-style), simplify it.

    For example,
    path = "/home/", => "/home"
    path = "/a/./b/../../c/", => "/c"
     */
    public static String simplifyPath(String path) {
        String[] inodes = path.split("/");
        Stack<String> stack = new Stack<String>();

        for (String inode : inodes) {
            if("..".equals(inode)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!".".equals(inode) && !inode.isEmpty()){
                stack.add(inode);
            }
        }

        String ret = stack.isEmpty() ? "" : stack.pop();
        while (!stack.isEmpty()) {
            ret = stack.pop() + "/" + ret;
        }

        return "/" + ret;
    }
}
