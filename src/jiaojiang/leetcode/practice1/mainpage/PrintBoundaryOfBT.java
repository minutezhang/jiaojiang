package jiaojiang.leetcode.practice1.mainpage;

import jiaojiang.leetcode.practice1.onlinejudge.TreeNode;
import jiaojiang.leetcode.practice1.onlinejudge.RecoverBST;

import java.util.List;
import java.util.ArrayList;

/**
 * @author: mizhang
 * @since: Aug 23, 2013 5:24:08 PM
 */
public class PrintBoundaryOfBT {

    public static void printBoundary(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        printLeftBoundary(root.left, false);
        printRightBoundary(root.right, false);

    }

    public static void printLeftBoundary(TreeNode root, boolean leafOnly) {
        if (root == null) {
            return;
        }

        if (!leafOnly || root.left == null && root.right == null) {
            System.out.println(root.val);
        }

        printLeftBoundary(root.left, leafOnly);
        printLeftBoundary(root.right, true);
    }

    public static void printRightBoundary(TreeNode root, boolean leafOnly) {
        if (root == null) {
            return;
        }

        printRightBoundary(root.left, true);
        printRightBoundary(root.right, leafOnly);

        if (!leafOnly || root.left == null && root.right == null) {
            System.out.println(root.val);
        }
    }

    public static void printBoundary2(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        
        List<Boolean> leafOnly = new ArrayList<Boolean>();
        leafOnly.add(false);
        printLeftBoundary2(root.left, leafOnly);

    }

    public static void printLeftBoundary2(TreeNode root, List<Boolean> leafOnly) {
        if (root == null) {
            return;
        }

        if (!leafOnly.get(0) || root.left == null && root.right == null) {
            System.out.println(root.val);
        }

        if (root.left == null && root.right == null) {
            leafOnly.set(0, true);
        }
        
        printLeftBoundary2(root.left, leafOnly);
        printLeftBoundary2(root.right, leafOnly);

    }

    public static void printRightBoundary2(TreeNode root, List<Boolean> leafOnly) {

    }

    public static void test() {
        printBoundary(RecoverBST.constructTree());  //
        System.out.println("--------5, 3, 10, 4 -- 7, 2, 8--------");
        printBoundary(RecoverBST.constructTree2());
        System.out.println("--------2 -- 1--------");
        printBoundary(RecoverBST.constructTree3());
        System.out.println("--------64, 41, -85, -73, -98, -124, -49 -- null --------");
    }

    public static void test2() {
        printBoundary2(RecoverBST.constructTree());  //
        System.out.println("--------5, 3, 10, 4 -- 7, 2, 8--------");
        printBoundary2(RecoverBST.constructTree2());
        System.out.println("--------2 -- 1--------");
        printBoundary2(RecoverBST.constructTree3());
        System.out.println("--------64, 41, -85, -73, -98, -124, -49 -- null --------");
    }

    public static void main(String[] args) {
        test();
    }

}
