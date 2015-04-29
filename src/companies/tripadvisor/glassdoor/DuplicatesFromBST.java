package companies.tripadvisor.glassdoor;

import java.util.ArrayList;
import java.util.List;

import utils.TreeNode;

/**
 * @author: zhang
 * @since: Apr 15, 2013 12:45:19 AM
 */
public class DuplicatesFromBST {
    //Count the number of duplicates in a BST without using recursion and constant space
    public static int getDuplicates(TreeNode bst) {
        return getDuplicatesHelp(bst, bst.val, -1);
    }

    public static int getDuplicatesHelp(TreeNode node, int pre, int count) {
        if (node == null) {
            return count;
        }

        int ret = getDuplicatesHelp(node.left, pre, count);

        if (pre == node.val) {
            return getDuplicatesHelp(node.right, pre, ret + 1);
        }

        return getDuplicatesHelp(node.right, node.val, ret);
    }

    public static void inOrderList(TreeNode node, List<Integer> nodeList) {
        if (node == null) {
            return;
        }

        inOrderList(node.left, nodeList);
        nodeList.add(node.val);
        inOrderList(node.right, nodeList);
    }

    public static int countListDuplicate(List<Integer> list) {
        if (list.size() == 0) {
            return 0;
        }

        int count = 0, element = list.get(0);
        for (int i = 1, n = list.size(); i < n; i++) {
            if (list.get(i) == element) {
                count++;
            } else {
                element = list.get(i);
            }
        }

        return count;
    }

    public static void testList() {
        TreeNode bst = TreeNode.getSampleBinarySearchTree2();

        List<Integer> list = new ArrayList<Integer>();
        inOrderList(bst, list);
        for (int i : list) {
            System.out.print(i + "\t");
        }
        System.out.println("\nTotal duplicates is: " + countListDuplicate(list) + "\n");

        System.out.println("Total duplicates is: " + getDuplicates(bst));
    }

    public static void main(String[] args) {
        testList();
    }
}